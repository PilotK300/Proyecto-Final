package com.example.models;

import com.example.controlador.utils.OwnFile;
import com.example.models.cuenta.Cuenta;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements IEmpresa, Serializable {
    private String nombre;
    private List<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;
    public Empresa() {
        this.nombre = "Empresa";
        this.clientes = new ArrayList<Cliente>();
        this.cuentas = new ArrayList<Cuenta>();
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean saveClients(String filename) {
        OwnFile<List<Cliente>> clientsFile = new OwnFile<>("saved/clients", filename+".txt");

        if (!clientsFile.getParentFile().exists()) {
            clientsFile.getParentFile().mkdirs();
        }

        return clientsFile.formatObjectToFile(this.clientes, "CLIENTS");
     }


    public void addClient(Cliente client) {
        this.clientes.add(client);
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

    public void addAccount(Cuenta cuenta, Cliente cliente) {
        this.cuentas.add(cuenta);
        cliente.setCuenta(cuenta);
    }
}

