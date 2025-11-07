package com.example.datawarehouse.ReporteGastos.Infraestructura.Kafka;

import com.example.comun.DTO.DW.ListadoFacturadoAnuncio;
import com.example.comun.DTO.DW.ReplicacionFacturaAnuncioDTO;
import com.example.comun.DTO.FacturaAnuncio.DiasDescuentoAnunciosBloqueados;
import com.example.comun.DTO.FacturaAnuncio.RespuestaAnuncioCreadoCineDTO;
import com.example.comun.DTO.FacturaAnuncio.RespuestaFacturaAnuncioCreadaDTO;
import com.example.datawarehouse.ReporteGastos.Aplicacion.Ports.Input.ReplicacionIngresosEgresosAnunciosInputPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class IngresosEgresosAnunciosCineKafkaAdaptador {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    private final ReplicacionIngresosEgresosAnunciosInputPort  replicacionIngresosEgresosAnunciosInputPort;


    @KafkaListener(topics = "ingreso-detalle-anuncio-facturacion", groupId = "dw-group")
    public void ingresoDetalleAnuncioFacturacion(
            @Payload String mensaje,
            @Header(value = KafkaHeaders.CORRELATION_ID, required = false) String correlationId
    )  throws Exception {
        System.out.println("LLEGA A FACTURACION REPLICADA");
        ListadoFacturadoAnuncio solicitud = objectMapper.readValue(mensaje, ListadoFacturadoAnuncio.class);
        //cambio a la factura del usuario
        this.replicacionIngresosEgresosAnunciosInputPort.ingresoInformacionTransaccional(solicitud.getListado());

    }

    @KafkaListener(topics = "ingreso-detalle-anuncio-bloqueo", groupId = "dw-group")
    @Transactional
    public void ingresoDetalleAnuncioBloqueo(
            @Payload String mensaje,
            @Header(value = KafkaHeaders.CORRELATION_ID, required = false) String correlationId
    )  throws Exception {
        System.out.println("LLEGA A FACTURACION REPLICADA");
        ListadoFacturadoAnuncio solicitud = objectMapper.readValue(mensaje, ListadoFacturadoAnuncio.class);
        //cambio a la factura del usuario
        this.replicacionIngresosEgresosAnunciosInputPort.ingresoInformacionTransaccional(solicitud.getListado());

    }
}
