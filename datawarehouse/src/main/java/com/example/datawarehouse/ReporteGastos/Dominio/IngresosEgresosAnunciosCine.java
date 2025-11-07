package com.example.datawarehouse.ReporteGastos.Dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngresosEgresosAnunciosCine {
    private UUID id;

    private UUID anuncio;
    private UUID usuario;
    private Double monto;
    private LocalDate fecha;
    private String estado;
    private String detalle;
    private UUID cine;


}
