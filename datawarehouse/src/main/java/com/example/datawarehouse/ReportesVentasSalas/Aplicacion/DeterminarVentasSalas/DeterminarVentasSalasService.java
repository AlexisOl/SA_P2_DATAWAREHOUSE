package com.example.datawarehouse.ReportesVentasSalas.Aplicacion.DeterminarVentasSalas;

import com.example.datawarehouse.ReportesVentasSalas.Aplicacion.Ports.Input.DeterminarVentasSalasInputPort;
import com.example.datawarehouse.ReportesVentasSalas.Aplicacion.Ports.Output.DeterminarVentasSalasOutputPort;
import org.springframework.stereotype.Service;

@Service
public class DeterminarVentasSalasService implements DeterminarVentasSalasInputPort {

    private final DeterminarVentasSalasOutputPort determinarVentasSalasOutputPort;

    public DeterminarVentasSalasService(DeterminarVentasSalasOutputPort determinarVentasSalasOutputPort){
        this.determinarVentasSalasOutputPort = determinarVentasSalasOutputPort;
    }
}
