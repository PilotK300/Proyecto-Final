package com.example.controlador;

public class Utils {
    private long CONSECUTIVO ;

    public Utils(long consecutivo) {
        this.CONSECUTIVO = consecutivo;
    }

    public long getCONSECUTIVO() {
        return ++CONSECUTIVO;
    }
}
