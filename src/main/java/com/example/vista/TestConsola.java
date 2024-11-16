package com.example.vista;

import com.example.controlador.ManejoArchivos;
import com.example.controlador.Utils;
import com.example.controlador.models.Auth;
import com.example.controlador.utils.OwnFile;
import com.example.models.Cliente;
import com.example.models.Empresa;
import com.example.models.IEmpresa;
import com.example.models.cuenta.Cuenta;
import com.example.models.cuenta.Postpago;
import com.example.models.cuenta.Prepago;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TestConsola {
    private Scanner sc = new Scanner(System.in);
    private ManejoArchivos controller = new ManejoArchivos();

    private IEmpresa empresa;
    private Utils utils = new Utils(
            empresa.getClientes().size()
    );

    public void loadSystem() {
        if (controller.getSystem().exists()) {
            System.out.println("El sistema existe, se va a cargar el sistema guardado");

            controller.getSystem().load();
        } else {
            System.out.println("El sistema no existe, se va a crear un nuevo sistema");
        }

        System.out.println();

        empresa = controller.getSystem().getEmpresa();
    }

    public void menu() {
        int opcion;
        do {
            System.out.print("""
                    Ingresa el numero del servicio que necesitas
                    \t1. Ingresar clientes
                    \t2. Agregar nueva cuenta de prepago o postpago
                    \t3. Agregar una llamada nacional o internacional
                    \t4. Agregar una recarga
                    \t5. Reporte de facturación postpago a fin de mes
                    \t6. Reporte de recargas a fin de mes
                    \t7. Guardar la empresa en un archivo como un objeto
                    \t8. Cargar de un archivo el objeto empresa
                    \t0. Salir del sistema
                    \t""");

            opcion = sc.nextInt();

            try {
                this.getClass().getMethod("menuOpcion" + opcion).invoke(this);
                /*
                Se encarga de llamar de manera dinámica, el metodo solicitado de acuerdo a la opción elegida
                Sería equivalente a...
                this.opcion1
                this.opcion2
                 */
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.err.println("La opción ingresada no es correcta");
            }
        } while (opcion != 0);
    }

    public void menuOpcion1() {


        System.out.print("""
                
                Ingresar clientes
                \t1. Agregar cliente
                \t2. Guardar Clientes en un archivo
                \t0. Regresar al menú anterior
                \t""");

        int opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.print("\tNombre: ");
            String name = sc.next();

            System.out.print("\tTipo de documento (CC, TI, Pasaporte): ");
            String type = sc.next();

            System.out.print("\tNúmero de docuemento: ");
            String id = sc.next();

            boolean found = false;
            for (Cliente client : empresa.getClientes()) {
                if (client.getIdentificacion().equals(id)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.err.println("\tEste documento ya está registrado, no se puede agregar el cliente");
            } else {
                System.out.print("\tDirección: ");
                String address = sc.next();

                Cliente cliente = new Cliente(name, type, id, address);

                empresa.addClient(cliente);

                System.out.println("\n\tEl cliente ha sido agregado con éxito\n");
            }
        } else if (opcion == 2) {

                System.out.print("""
                        
                        Ingrese el nombre del archivo: """);

                String fileName = sc.nextLine();

                File clientFile = new File("saved/clients", fileName + ".txt");

                OwnFile clientOwnFile = new OwnFile(clientFile);

                controller.loadClients(clientOwnFile);
        }
    }

    public void menuOpcion2() {
        int opTypeAccount;
        System.out.println("""
                Seleccione el tipo de cuenta que quiere agregar
                \t1.Prepago
                \t2.Postpago
                """);
        opTypeAccount = sc.nextInt();

        System.out.print("Ingrese el numero de telefono");
        Long phoneNumber = sc.nextLong();

        Cuenta cuenta = null;
        if (opTypeAccount == 1) {

            cuenta = new Prepago(
                    (long) utils.getCONSECUTIVO(),//Crear el ID
                    phoneNumber,
                    100L
            );
        } else if (opTypeAccount == 2) {

            cuenta = new Postpago(
                    (long) utils.getCONSECUTIVO(),
                    phoneNumber,
                    50000L
            );
        }


        String numDocumento;
        System.out.println("Ingresa el número de documento del cliente ");
        numDocumento=sc.nextLine();

        boolean found=false;
        Cliente foundClient = null;
        for (Cliente cliente:empresa.getClientes()){
            if(numDocumento.equals(cliente.getIdentificacion())){
                found=true;
                foundClient=cliente;
                break;
            }
        }

        if(found) {
            empresa.addAccount(cuenta, foundClient);
            assert cuenta != null;
            System.out.println("El id de la cuenta es"+cuenta.getId());
        } else {
            System.err.println("No se encontró el cliente");
        }
    }
    public void menuOpcion3(){
        //Primero se pide la cuenta que se tiene en el sistema
        long numeroCuenta;
        System.out.println("Selecciona el numero de la cuenta");
        numeroCuenta= sc.nextLong();
        System.out.println();
    }
}

