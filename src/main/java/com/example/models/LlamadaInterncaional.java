package com.example.models;
import com.example.models.cuenta.Cuenta;
import com.example.models.cuenta.Prepago;

import java.time.LocalDate;
import java.util.ArrayList;

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
    public long calcularValor(Cuenta cuenta) {
        if(cuenta instanceof Prepago) {
            return (120 * getDuracion());//100*20% es igual a 120
        }return 0L;//En el caso de empresa A nunca decía el valor adicional para cuenta postpago de llamada internacional
    }
    public long verElPais(String paisDestino) {
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

        paises.add("Belgica");
        diminutivos.add(32);

        paises.add("Colombia");
        diminutivos.add(57);

        paises.add("Canada");
        diminutivos.add(1);

        paises.add("China");
        diminutivos.add(86);

        paises.add("Dinamarca");
        diminutivos.add(45);

        paises.add("Egipto");
        diminutivos.add(20);

        paises.add("Francia");
        diminutivos.add(33);

        paises.add("Alemania");
        diminutivos.add(49);

        paises.add("India");
        diminutivos.add(91);

        paises.add("Indonesia");
        diminutivos.add(62);

        paises.add("Italia");
        diminutivos.add(39);

        paises.add("Japon");
        diminutivos.add(81);

        paises.add("Mexico");
        diminutivos.add(52);

        paises.add("Nigeria");
        diminutivos.add(234);

        paises.add("Rusia");
        diminutivos.add(7);

        paises.add("Sur Africa");
        diminutivos.add(27);

        paises.add("Reino Unido");
        diminutivos.add(44);

        paises.add("Estados Unidos");
        diminutivos.add(1);

        paises.add("Venezuela");
        diminutivos.add(58);
        int contador=0;
        for (int i = 0; i < diminutivos.size(); i++) {
            contador=i;
            if (paises.get(i).equalsIgnoreCase(paisDestino)) {
                return diminutivos.get(i);
            }
        }return 0;
    }
}
