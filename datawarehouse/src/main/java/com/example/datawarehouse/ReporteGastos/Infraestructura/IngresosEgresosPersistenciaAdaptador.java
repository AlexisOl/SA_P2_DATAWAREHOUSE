package com.example.datawarehouse.ReporteGastos.Infraestructura;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.ReplicacionIngresosEgresosAnunciosOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Mapper.IngresoEgresosAnunciosCineMapper;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Repository.IngresosEgresosAnunciosCineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngresosEgresosPersistenciaAdaptador implements DeterminarIngresosTiempoCineOutputPort, ReplicacionIngresosEgresosAnunciosOutputPort {
    private final IngresosEgresosAnunciosCineRepository ingresosEgresosAnunciosCineRepository;
    private final IngresoEgresosAnunciosCineMapper ingresoEgresosAnunciosCineMapper;
    @Override
    public void ingresoInformacionTransaccional(IngresosEgresosAnunciosCine replicacionFacturaAnuncioDTO) {
        this.ingresosEgresosAnunciosCineRepository.save(
                this.ingresoEgresosAnunciosCineMapper.toIngresosEgresosAnunciosCineEntity(replicacionFacturaAnuncioDTO));
    }
}
