package com.example.datawarehouse.PagosDevolucionBloqueoCine.Aplicacion.DeterminarIngresosTiempo;

import com.example.datawarehouse.PagosDevolucionBloqueoCine.Aplicacion.Ports.Input.DeterminarIngresosTiempoCineInputPort;
import com.example.datawarehouse.PagosDevolucionBloqueoCine.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import org.springframework.stereotype.Service;

@Service
public class DeterminarIngresosTiempoService implements DeterminarIngresosTiempoCineInputPort {

    private final DeterminarIngresosTiempoCineOutputPort determinarIngresosTiempoCineOutputPort;

    public DeterminarIngresosTiempoService(DeterminarIngresosTiempoCineOutputPort determinarIngresosTiempoCineOutputPort){
        this.determinarIngresosTiempoCineOutputPort = determinarIngresosTiempoCineOutputPort;
    }
}
