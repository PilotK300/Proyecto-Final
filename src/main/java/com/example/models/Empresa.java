package com.example.models;

import com.example.models.cuenta.Cuenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements IEmpresa, Serializable {
    private String nombre;
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}

