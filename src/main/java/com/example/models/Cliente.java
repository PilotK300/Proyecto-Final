package com.example.models;

import com.example.controlador.utils.FileRow;
import com.example.controlador.utils.OwnFile;
import com.example.models.cuenta.Cuenta;
import com.example.models.cuenta.Prepago;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements FileRow {
    public String nombre;
    public String tipoId;
    public String identificacion;
    public String direccion;
    public Cuenta cuenta;

    public Cliente(String nombre, String tipoid, String identificacion, String direccion, Cuenta cuenta) {
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoId = tipoid;
        this.cuenta = cuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }


}
