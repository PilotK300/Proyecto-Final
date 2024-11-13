package com.example.models;

import com.example.controlador.utils.OwnFile;
import com.example.models.cuenta.Cuenta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String direccion;
    private String identificacion;
    private String nombre;
    private String tipoId;
    private Cuenta cuenta;

    public Cliente(String direccion, String identificacion, String nombre, String tipoid, Cuenta cuenta) {
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

    public static List<Cliente> getClientsFromFileURI(OwnFile usersFile) {
        // Todo: Create logic for obtaining client list
        if (!usersFile.getFile().exists()) return null;

        return new ArrayList<Cliente>();
    }
}
