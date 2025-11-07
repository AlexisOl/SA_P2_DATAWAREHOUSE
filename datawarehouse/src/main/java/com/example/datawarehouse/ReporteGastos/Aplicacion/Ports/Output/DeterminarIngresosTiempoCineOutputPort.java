package com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output;

import com.example.datawarehouse.ReporteGastos.Dominio.ReporteMensualDTO;

import java.util.List;
import java.util.UUID;

public interface DeterminarIngresosTiempoCineOutputPort {
    List<ReporteMensualDTO> obtenerReporteMensualPorCine(UUID cineId);
}
