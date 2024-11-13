package com.example.models.cuenta;

import com.example.models.Recarga;

import java.util.List;

public class Prepago extends Cuenta{
    private Long numeroMinutos;
    private List<Recarga> recargas;

    public Prepago(Long id, Long numero, Long numeroMinutos) {
        super(id, numero);
        this.numeroMinutos = numeroMinutos;
    }

    public Long getNumeroMinutos() {
        return numeroMinutos;
    }

    public void setNumeroMinutos(Long numeroMinutos) {
        this.numeroMinutos = numeroMinutos;
    }

    public List<Recarga> getRecargas() {
        return recargas;
    }

    public void setRecargas(List<Recarga> recargas) {
        this.recargas = recargas;
    }
}
