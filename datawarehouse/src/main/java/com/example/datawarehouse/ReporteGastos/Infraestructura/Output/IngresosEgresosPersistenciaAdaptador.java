package com.example.datawarehouse.ReporteGastos.Infraestructura.Output;

import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.ReplicacionIngresosEgresosAnunciosOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.ReporteMensualDTO;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Output.Entity.IngresosEgresosAnunciosCineEntity;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Output.Repository.IngresosEgresosAnunciosCineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class IngresosEgresosPersistenciaAdaptador implements  ReplicacionIngresosEgresosAnunciosOutputPort, DeterminarIngresosTiempoCineOutputPort {
    private final IngresosEgresosAnunciosCineRepository ingresosEgresosAnunciosCineRepository;
    @Override
    @Transactional
    public void ingresoInformacionTransaccional(IngresosEgresosAnunciosCineEntity replicacionFacturaAnuncioDTO) {
        this.ingresosEgresosAnunciosCineRepository.save(
                (replicacionFacturaAnuncioDTO));
    }

    @Override
    public List<ReporteMensualDTO> obtenerReporteMensualPorCine(UUID cineId) {
            List<Object[]> rows = ingresosEgresosAnunciosCineRepository.reporteMensualPagos(cineId);
        return rows.stream()
                .map(row -> new ReporteMensualDTO(
                        (String) row[0],
                        row[1] != null ? new BigDecimal(((Number) row[1]).doubleValue()) : BigDecimal.ZERO,
                        row[2] != null ? new BigDecimal(((Number) row[2]).doubleValue()) : BigDecimal.ZERO,
                        row[3] != null ? new BigDecimal(((Number) row[3]).doubleValue()) : BigDecimal.ZERO
                ))
                .toList();

    }
}
