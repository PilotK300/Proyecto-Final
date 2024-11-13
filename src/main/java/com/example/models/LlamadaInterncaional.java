package com.example.models;

import java.time.LocalDate;

public class LlamadaInterncaional extends Llamada {
    private String paisDestino;

    public LlamadaInterncaional(long duracion, LocalDate fecha, long telefonoDestinatario, long valor, String paisDestino) {
        super(duracion, fecha, telefonoDestinatario, valor);
        this.paisDestino = paisDestino;
    }
    public String getPaisDestino() {
        return paisDestino;
    }
    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    @Override
    public long calcularValor() {
        return 234L;
    }
}
