package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Entity.IngresosEgresosAnunciosCineEntity;

public interface ReplicacionIngresosEgresosAnunciosOutputPort {
    void ingresoInformacionTransaccional(IngresosEgresosAnunciosCineEntity replicacionFacturaAnuncioDTO);

}
