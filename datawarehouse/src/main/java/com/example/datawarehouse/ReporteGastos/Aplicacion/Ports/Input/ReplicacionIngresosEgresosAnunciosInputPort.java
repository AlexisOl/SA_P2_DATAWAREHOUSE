package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;

import java.util.List;

public interface ReplicacionIngresosEgresosAnunciosInputPort {
    void ingresoInformacionTransaccional(List<ReplicacionFacturaAnuncioDTO> replicacionFacturaAnuncioDTO);

}
