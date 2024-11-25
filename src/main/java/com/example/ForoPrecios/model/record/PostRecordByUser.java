package com.example.ForoPrecios.model.record;

import java.util.List;

public record PostRecordByUser(List<PostRecord> posts, String nombre, int cantidadPosts) {
}
