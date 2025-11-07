package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output;

import com.example.datawarehouse.ReporteGastos.Infraestructura.Output.Entity.IngresosEgresosAnunciosCineEntity;

public interface ReplicacionIngresosEgresosAnunciosOutputPort {
    void ingresoInformacionTransaccional(IngresosEgresosAnunciosCineEntity replicacionFacturaAnuncioDTO);

}
