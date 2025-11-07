package com.example.datawarehouse.ReporteGastos.Infraestructura.Output.Repository;

import com.example.datawarehouse.ReporteGastos.Infraestructura.Output.Entity.IngresosEgresosAnunciosCineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IngresosEgresosAnunciosCineRepository extends JpaRepository<IngresosEgresosAnunciosCineEntity , UUID> {

    @Query(value = """
    WITH RECURSIVE meses AS (
        SELECT DATE_FORMAT(MIN(fecha), '%Y-%m-01') AS mes_inicio,
               LAST_DAY(CURDATE()) AS mes_fin
        FROM dw_db.ingreso_egreso_replicacion_anuncio
        WHERE cine = :cineId
        
        UNION ALL
        
        SELECT DATE_FORMAT(DATE_ADD(mes_inicio, INTERVAL 1 MONTH), '%Y-%m-01'),
               mes_fin
        FROM meses
        WHERE DATE_ADD(mes_inicio, INTERVAL 1 MONTH) <= mes_fin
    )
    SELECT 
        DATE_FORMAT(m.mes_inicio, '%m/%Y') AS mes,
        COALESCE(SUM(CASE WHEN p.detalle = 'Pago de ocultacion de anuncio' THEN p.monto END), 0) AS pagos_ocultacion,
        COALESCE(SUM(CASE WHEN p.detalle = 'Ingreso' THEN p.monto END), 0) AS ingresos,
        COALESCE(SUM(p.monto), 0) AS total
    FROM meses m
    LEFT JOIN dw_db.ingreso_egreso_replicacion_anuncio p 
        ON p.cine = :cineId
       AND p.fecha >= m.mes_inicio
       AND p.fecha < DATE_ADD(m.mes_inicio, INTERVAL 1 MONTH)
       AND p.estado = 'EXITOSA'
    GROUP BY m.mes_inicio
    ORDER BY m.mes_inicio;
""", nativeQuery = true)
    List<Object[]> reporteMensualPagos(@Param("cineId") UUID cineId);


}
