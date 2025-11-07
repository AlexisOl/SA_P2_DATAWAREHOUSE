package com.example.datawarehouse.ReporteGastos.Infraestructura.Mapper;

import com.example.datawarehouse.ReporteGastos.Dominio.IngresosEgresosAnunciosCine;
import com.example.datawarehouse.ReporteGastos.Infraestructura.Entity.IngresosEgresosAnunciosCineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IngresoEgresosAnunciosCineMapper {

    IngresosEgresosAnunciosCine toIngresosEgresosAnunciosCine(IngresosEgresosAnunciosCineEntity  ingresosEgresosAnunciosCineEntity);
    IngresosEgresosAnunciosCineEntity toIngresosEgresosAnunciosCineEntity(IngresosEgresosAnunciosCine ingresosEgresosAnunciosCine);
}
