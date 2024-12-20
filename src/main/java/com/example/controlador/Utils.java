package com.example.controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Utils {
    private static long CONSECUTIVO;
    public Utils(long consecutivo) {
        this.CONSECUTIVO = consecutivo;
    }

    public long getCONSECUTIVO() {
        return ++CONSECUTIVO;
    }
    public static LocalDate formatearFecha(String fecha, DateFormat formato) {
        try {
            Date date = formato.parse(fecha);

            return date.toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido: " + fecha);
            return null;
        }
    }

    public static String capitalizeFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    public static String convertLongToString(long number) {
        return Long.toString(number);
    }
}

