package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input;

import com.example.datawarehouse.ReporteGastos.Dominio.ReporteMensualDTO;

import java.util.List;
import java.util.UUID;

public interface DeterminarIngresosTiempoCineInputPort {
    List<ReporteMensualDTO> ejecutar(UUID cineId);
}
