package com.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public abstract long calcularValor();

    public int verElPais(int diminutivo) {
        ArrayList<String> paises = new ArrayList<String>();
        ArrayList<Integer> diminutivos = new ArrayList<Integer>();
        paises.add("Afghanistan");
        diminutivos.add(93);

        paises.add("Albania");
        diminutivos.add(355);

        paises.add("Algeria");
        diminutivos.add(213);

        paises.add("Argentina");
        diminutivos.add(54);

        paises.add("Australia");
        diminutivos.add(61);

        paises.add("Austria");
        diminutivos.add(43);

        paises.add("Bangladesh");
        diminutivos.add(880);

        paises.add("Belgium");
        diminutivos.add(32);

        paises.add("Colombia");
        diminutivos.add(57);

        paises.add("Canada");
        diminutivos.add(1);

        paises.add("China");
        diminutivos.add(86);

        paises.add("Denmark");
        diminutivos.add(45);

        paises.add("Egypt");
        diminutivos.add(20);

        paises.add("France");
        diminutivos.add(33);

        paises.add("Germany");
        diminutivos.add(49);

        paises.add("India");
        diminutivos.add(91);

        paises.add("Indonesia");
        diminutivos.add(62);

        paises.add("Italy");
        diminutivos.add(39);

        paises.add("Japan");
        diminutivos.add(81);

        paises.add("Mexico");
        diminutivos.add(52);

        paises.add("Nigeria");
        diminutivos.add(234);

        paises.add("Russia");
        diminutivos.add(7);

        paises.add("South Africa");
        diminutivos.add(27);

        paises.add("United Kingdom");
        diminutivos.add(44);

        paises.add("United States");
        diminutivos.add(1);

        paises.add("Venezuela");
        diminutivos.add(58);

        for (int i = 0; i < diminutivos.size(); i++) {
            if(diminutivos.get(i)==diminutivo){
                return i;
            }
        }return 0;
    }
}
