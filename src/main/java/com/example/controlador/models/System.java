package com.example.controlador.models;

import com.example.models.Empresa;

import java.io.*;

public class System {
    private final File systemFile = new File("backup", "Empresa.dat");

    public static final int STATUS_FILE_NOT_FOUND = 1;
    public static final int STATUS_FILE_WRITTEN = 2;
    public static final int STATUS_FILE_DELETED = 3;

    private Empresa empresa;

    public System() {
        empresa = new Empresa();
    }
    public System(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean save() throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(systemFile))) {
            oos.writeObject(empresa);

            return true;
        }catch (Exception e) {
            java.lang.System.err.println("Error al escribir el archivo");
            java.lang.System.err.println(e.getMessage());
            return false;
        }
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(systemFile))) {
            empresa = (Empresa) ois.readObject();
        } catch (Exception e) {
            java.lang.System.err.println("Error al leer el archivo");
            java.lang.System.err.println(e.getMessage());
        }
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public boolean exists() {
        return systemFile.exists();
    }
}
