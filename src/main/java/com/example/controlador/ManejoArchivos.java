package com.example.controlador;

import com.example.controlador.models.Auth;
import com.example.controlador.models.System;
import com.example.controlador.utils.OwnFile;
import com.example.models.Cliente;
import com.example.models.Empresa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManejoArchivos {
    /*
    private Auth auth = new Auth();

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Cliente buscarCliente() {
        return new Cliente("", "", "", "", 2L);
    }

    public int clientExists() {
        Cliente cliente = buscarCliente();

        if (cliente == null) {
            return Auth.status.LOGIN_NOT_EXISTS;
        }

        return Auth.status.LOGIN_EXISTS;
    }*/

    private final System system = new System();

    public System getSystem() {
        return this.system;
    }

    public void saveClients(String usersFile) {
        this.system.getEmpresa().saveClients(usersFile);
    }
}
