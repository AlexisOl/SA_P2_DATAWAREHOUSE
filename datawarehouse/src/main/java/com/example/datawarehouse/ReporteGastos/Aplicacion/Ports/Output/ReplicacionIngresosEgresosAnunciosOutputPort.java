package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;

public interface ReplicacionIngresosEgresosAnunciosOutputPort {
    void ingresoInformacionTransaccional(IngresosEgresosAnunciosCine replicacionFacturaAnuncioDTO);

}
