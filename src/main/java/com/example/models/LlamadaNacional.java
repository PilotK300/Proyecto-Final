package com.example.models;

import java.time.LocalDate;

public class LlamadaNacional extends Llamada{
    private long calcularValor;

    public LlamadaNacional(
            long duracion,
            LocalDate fecha,
            long telefonoDestinatario,
            long valor
    ) {
        super(duracion, fecha, telefonoDestinatario, valor);
        this.calcularValor = valor;
    }

    public long getCalcularValor() {
        return calcularValor;
    }

    public void setCalcularValor(long calcularValor) {
        this.calcularValor = calcularValor;
    }

    @Override
    public long calcularValor() {
        return 0L;
    }
}
