package com.example.models.cuenta;

public class Postpago extends Cuenta{
    private Long cargoFijo;

    public Postpago(Long id, Long numero, Long cargoFijo) {
        super(id, numero);
        this.cargoFijo = cargoFijo;
    }

    public Long getCargoFijo() {
        return cargoFijo;
    }

    public void setCargoFijo(Long cargoFijo) {
        this.cargoFijo = cargoFijo;
    }
}
