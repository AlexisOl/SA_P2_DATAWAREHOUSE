package com.example.datawarehouse.ReporteGastos.Infraestructura;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.ReplicacionIngresosEgresosAnunciosOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Entity.IngresosEgresosAnunciosCineEntity;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Mapper.IngresoEgresosAnunciosCineMapper;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Repository.IngresosEgresosAnunciosCineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class IngresosEgresosPersistenciaAdaptador implements  ReplicacionIngresosEgresosAnunciosOutputPort {
    private final IngresosEgresosAnunciosCineRepository ingresosEgresosAnunciosCineRepository;
    private final IngresoEgresosAnunciosCineMapper ingresoEgresosAnunciosCineMapper;
    @Override
    @Transactional
    public void ingresoInformacionTransaccional(IngresosEgresosAnunciosCineEntity replicacionFacturaAnuncioDTO) {
        this.ingresosEgresosAnunciosCineRepository.save(
                (replicacionFacturaAnuncioDTO));
    }
}
