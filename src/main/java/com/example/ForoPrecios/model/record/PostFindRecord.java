package com.example.ForoPrecios.model.record;

import java.time.ZonedDateTime;

public record PostFindRecord(String producto, double precio, ZonedDateTime fecha,
                             String nombre, String local, String categoria) {
}
