package com.example.ForoPrecios.model.enums;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public enum Antiguedad {
    DOCE_HORAS(12, ChronoUnit.HOURS),
    UN_DIA(1, ChronoUnit.DAYS),
    UNA_SEMANA(7, ChronoUnit.DAYS),
    UN_MES(30, ChronoUnit.DAYS);

    private int cantidad;
    private ChronoUnit unidad;

    private Antiguedad(int i, ChronoUnit chronoUnit) {
        this.cantidad = i;
        this.unidad = chronoUnit;
    }

    public Instant getTime(){
        return Instant.now().minus(this.cantidad, this.unidad);
    }

}
