package com.example.controlador.utils;

import com.example.controlador.Utils;
import com.example.models.Cliente;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OwnFile<T> extends File {

    public OwnFile(String pathname) {
        super(pathname);
    }

    public OwnFile(String parent, String child) {
        super(parent, child);
    }

    public boolean formatObjectToFile(T object) {
        return this.formatObjectToFile(object, object.getClass().getSimpleName().toUpperCase());
    }

    public boolean formatObjectToFile(T object, String title) {
        StringBuilder builder = new StringBuilder();

        List<String> columns = new ArrayList<>();
        List<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();

        builder
                .append("#").append(title).append("\n");



        if (object instanceof List) {
            Table table = new Table();

            Field[] fields = ((List<?>) object).getFirst().getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field column = fields[i];
                table.addColumn(column.getName());
            }

            boolean first = true;
            for (Object item : (List<?>) object) {
                Row row = table.addRow(new Row());

                for(int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    try {
                        Object value = field.get(item);
                        row.addCell(
                                new Cell(
//                                        item.getClass().getMethod("get"+ Utils.capitalizeFirst(field.getName())).invoke(item, new ArrayList() ),
                                        (Objects.isNull(value))? "<null>" : value.toString(),
                                        table.columns.get(i)
                                )
                        );
                    } catch (IllegalAccessException e) {
                        System.err.println("Error al agregar una celda: ");
                        System.err.println(e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Error al agregar una celda: ");
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            builder.append(table);
        }

        System.out.println(builder);

        try (java.io.FileWriter writer = new FileWriter(this, false)) {
            writer.write(builder.toString());
            System.out.println("El archivo se ha guardado de forma correcta");;
            return true;
        } catch (IOException e) {
            System.err.println("No se pudo agregar al usuario");
            System.err.println(e.getMessage());
            return false;
        }
    }

    /*public List<Cliente> getFromFile() {

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
    }*/
}

class Column {
    final String name;
    int minColumnSize = 0;

    public Column(int minColumnSize, String name) {
        this.minColumnSize = minColumnSize;
        this.name = name
                .substring(0, 1)
                .toUpperCase()
                .concat(name.substring(1).toLowerCase());
    }
}

class Cell {
    String value;
    Column column;

    public Cell(String value, Column column) {
        this.value = value;
        this.column = column;

        if (this.column.minColumnSize < this.value.length()) {
            this.column.minColumnSize = this.value.length();
        }
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        value.append(this.value);

        for (int i = 0; i <= column.minColumnSize - this.value.length(); i++) {
            value.append(" ");
        }

        return value.toString();
    }
}

class Row {
    List<Cell> cells = new ArrayList<Cell>();

    void addCell(Cell cell) {
        cells.add(cell);
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();

        for (Cell cell : cells) {

            value.append(cell.toString());
        }

        return value.toString();
    }
}

class Table {
    List<Column> columns = new ArrayList<Column>();
    List<Row> rows = new ArrayList<Row>();

    Row addRow(Row row) {
        rows.add(row);
        return this.rows.get(rows.size() - 1);
    }

    void addColumn(Column column) {
        columns.add(column);
    }

    void addColumn(String title) {
        int minColumnSize = title.length()+2;

        columns.add(new Column(minColumnSize, title));
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        
        value.append("#");
//        System.out.println(columns.size());
        for (Column column : columns) {
            value.append(column.name);

            for (int i = 0; i <= column.minColumnSize - column.name.length() ; i++) {
                value.append(" ");
            }
        }
        value.append("\n");
        

        for (Row row : rows) {
            value.append(" ").append(row.toString()).append("\n");
        }

        return value.toString();
    }
}