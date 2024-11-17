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
    public void agregarMinutosPorRecarga(Recarga recarga) {
        long minutosRecarga = recarga.getValor() / 100;
        this.numeroMinutos += minutosRecarga;

        System.out.println("Se han agregado " + minutosRecarga + " minutos.");
        System.out.println("Minutos disponibles: " + this.numeroMinutos);
    }
}
