package com.example.models.cuenta;

import com.example.models.Llamada;

import java.util.List;

public abstract class Cuenta {
    private Long id;
    private Long numero;
    private List<Llamada> Llamadas;

    public Cuenta(Long id, Long numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long obtenerPagoCuenta() {
        return 0L;
    }

    public List<Llamada> getLlamadas() {
        return Llamadas;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        Llamadas = llamadas;
    }

}
