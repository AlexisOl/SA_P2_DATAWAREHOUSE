package com.example.datawarehouse.ReporteGastos.Aplicacion.CasosUso.VerPagosTransaccionales;

import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.DeterminarIngresosTiempoCineInputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.DeterminarIngresosTiempoCineOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.ReporteMensualDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VerPagosTransaccionalesService implements DeterminarIngresosTiempoCineInputPort {

    private final DeterminarIngresosTiempoCineOutputPort repositoryPort;

    public VerPagosTransaccionalesService(DeterminarIngresosTiempoCineOutputPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }



    @Override
    public List<ReporteMensualDTO> ejecutar(UUID cineId) {
        System.out.println(cineId);

        List<ReporteMensualDTO> reportes = repositoryPort.obtenerReporteMensualPorCine(cineId);
        return reportes.stream()
                .map(r -> new ReporteMensualDTO(
                        r.getMes(),
                        r.getPagosOcultacion(),
                        r.getIngresos(),
                        r.getTotal()
                ))
                .toList();
    }
}