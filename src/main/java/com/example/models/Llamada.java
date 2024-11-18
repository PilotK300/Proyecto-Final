package com.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.models.cuenta.Cuenta;

public abstract class Llamada {
    private long duracion;
    private LocalDate fecha;
    private long telefonoDestinatario;
    private long valor;

    public Llamada(long duracion, LocalDate fecha, long telefonoDestinatario, long valor) {
        this.duracion = duracion;
        this.fecha = fecha;
        this.telefonoDestinatario = telefonoDestinatario;
        this.valor = valor;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(long telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public abstract long calcularValor(Cuenta cuenta);


}
