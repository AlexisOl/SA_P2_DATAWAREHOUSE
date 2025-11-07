package com.example.datawarehouse.ReporteGastos.Infraestructura.Input;

import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.DeterminarIngresosTiempoCineInputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.ReporteMensualDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reportes")
public class ReporteGastosController {

    private final DeterminarIngresosTiempoCineInputPort reporteService;



    @GetMapping("/{cineId}")
    public List<ReporteMensualDTO> obtenerReporte(@PathVariable("cineId") UUID cineId) {
        return reporteService.ejecutar(cineId);
    }

}
