package com.example.models;

import com.example.models.cuenta.Cuenta;

import java.util.ArrayList;
import java.util.List;

public interface IEmpresa {
    public List<Cliente> getClientes();
    public boolean saveClients(String filename);
    public void addClient(Cliente client);
    public List<Cuenta> getCuentas();
    public void addAccount(Cuenta cuenta, Cliente cliente);
}
