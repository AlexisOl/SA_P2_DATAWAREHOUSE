package com.example.datawarehouse.ReporteGastos.Dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMensualDTO {
    private String mes;
    private BigDecimal pagosOcultacion;
    private BigDecimal ingresos;
    private BigDecimal total;
}
