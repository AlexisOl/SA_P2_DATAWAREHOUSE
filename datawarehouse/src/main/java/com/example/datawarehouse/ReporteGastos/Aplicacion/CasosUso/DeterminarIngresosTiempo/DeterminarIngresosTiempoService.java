package com.example.datawarehouse.ReporteGastos.Aplicacion.CasosUso.DeterminarIngresosTiempo;

import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.DeterminarIngresosTiempoCineInputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import org.springframework.stereotype.Service;

@Service
public class DeterminarIngresosTiempoService implements DeterminarIngresosTiempoCineInputPort {

    private final DeterminarIngresosTiempoCineOutputPort determinarIngresosTiempoCineOutputPort;

    public DeterminarIngresosTiempoService(DeterminarIngresosTiempoCineOutputPort determinarIngresosTiempoCineOutputPort){
        this.determinarIngresosTiempoCineOutputPort = determinarIngresosTiempoCineOutputPort;
    }
}
