package com.example.datawarehouse.ReporteGastos.Aplicacion.CasosUso.ReplicacionIngresosEgresosAnuncios;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.comun.DTO.FacturaAnuncio.RespuestaAnuncioCreadoCineDTO;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.ReplicacionIngresosEgresosAnunciosInputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.ReplicacionIngresosEgresosAnunciosOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service

public class ReplicacionIngresosEgresosAnunciosService implements ReplicacionIngresosEgresosAnunciosInputPort {
    private final ReplicacionIngresosEgresosAnunciosOutputPort replicacionIngresosEgresosAnunciosOutputPort;


    public ReplicacionIngresosEgresosAnunciosService(ReplicacionIngresosEgresosAnunciosOutputPort replicacionIngresosEgresosAnunciosOutputPort) {
        this.replicacionIngresosEgresosAnunciosOutputPort= replicacionIngresosEgresosAnunciosOutputPort;
    }

    @Override

    public void ingresoInformacionTransaccional(List<ReplicacionFacturaAnuncioDTO> replicacionFacturaAnuncioDTO) {
        for (ReplicacionFacturaAnuncioDTO replicacion: replicacionFacturaAnuncioDTO) {
            System.out.println(                   replicacion.getId()
                            +" ------ \n"+
                    replicacion.getAnuncio()
                            +"------\n"+
                    replicacion.getUsuario()
                            +"------\n"+
                    replicacion.getMonto()
                            +"------\n"+
                    replicacion.getFecha()
                            +"------\n"+
                    replicacion.getEstado()
                            +"------\n"+
                    replicacion.getDetalle()
                    +"------\n"+
                    replicacion.getCine());
            this.replicacionIngresosEgresosAnunciosOutputPort.ingresoInformacionTransaccional(
                    new IngresosEgresosAnunciosCine(
                            replicacion.getId(),
                            replicacion.getAnuncio(),
                            replicacion.getUsuario(),
                            replicacion.getMonto(),
                            replicacion.getFecha(),
                            replicacion.getEstado(),
                            replicacion.getDetalle(),
                            replicacion.getCine()
                    ));
        }

    }
}
