package com.example.models;
import com.example.models.cuenta.Cuenta;
import com.example.models.cuenta.Postpago;
import com.example.models.cuenta.Prepago;
import java.time.LocalDate;

public class LlamadaNacional extends Llamada{
    private long calcularValor;
    private LocalDate fecha;
    private long duracion;
    private long telefonoDestinatario;
    private long valor;


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
    public long calcularValor(Cuenta cuenta){
        if(cuenta instanceof Prepago) {
            return 100 * getDuracion();
        }return 0L;
    }
}
