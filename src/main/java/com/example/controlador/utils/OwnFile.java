package com.example.controlador.utils;

import com.example.models.Cliente;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class OwnFile<T> {
    private final File file;

    public OwnFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public void formatObjectToFile(T object) {
        StringBuilder builder = new StringBuilder();

        String title = object.getClass().getSimpleName().toUpperCase();

        Field[] columns = object.getClass().getDeclaredFields();

        builder
                .append("#").append(title).append("\n");

        builder
                .append("#");

        for (Field column : columns) {
            builder.append(column.getName()).append(",");
        }

        System.out.println(builder);
    }

    public List<Cliente> getFromFile() {

//        List<String> lines = new Array
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            System.err.println("El archivo solicitado no ha sido encontrado");
        }

        return null;
    }
}
