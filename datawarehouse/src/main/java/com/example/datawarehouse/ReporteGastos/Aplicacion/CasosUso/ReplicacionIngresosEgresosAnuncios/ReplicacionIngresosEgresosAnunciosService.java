package com.example.datawarehouse.ReporteGastos.Aplicacion.CasosUso.ReplicacionIngresosEgresosAnuncios;

import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.comun.DTO.FacturaAnuncio.RespuestaAnuncioCreadoCineDTO;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.ReplicacionIngresosEgresosAnunciosInputPort;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Output.ReplicacionIngresosEgresosAnunciosOutputPort;
import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Entity.IngresosEgresosAnunciosCineEntity;
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
            IngresosEgresosAnunciosCineEntity entidad = new IngresosEgresosAnunciosCineEntity(
                    replicacion.getId(),
                    replicacion.getAnuncio(),
                    replicacion.getUsuario(),
                    replicacion.getMonto(),
                    replicacion.getFecha(),
                    "EXITOSA",
                    replicacion.getDetalle(),
                    replicacion.getCine()
            );

            // guardar directamente
            this.replicacionIngresosEgresosAnunciosOutputPort.ingresoInformacionTransaccional(entidad);

        }

    }
}
