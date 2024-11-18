package com.example.controlador.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public interface FileRow {
    static List<String> getColumnNames(Class<? extends FileRow> clazz) {
        // Get all declared fields from the implementing class
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(Field::isSynthetic)
                .map(Field::getName)
                .collect(Collectors.toList());
    }
}
