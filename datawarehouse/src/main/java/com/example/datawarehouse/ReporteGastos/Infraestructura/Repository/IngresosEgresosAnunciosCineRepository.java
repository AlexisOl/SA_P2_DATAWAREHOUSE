package com.example.datawarehouse.ReporteGastos.Infraestructura.Repository;

import com.example.datawarehouse.ReporteGastos.Infraestructura.Entity.IngresosEgresosAnunciosCineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngresosEgresosAnunciosCineRepository extends JpaRepository<IngresosEgresosAnunciosCineEntity , UUID> {
}
