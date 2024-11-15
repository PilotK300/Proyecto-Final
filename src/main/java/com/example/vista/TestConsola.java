package com.example.vista;

import com.example.controlador.ManejoArchivos;
import com.example.controlador.models.Auth;
import com.example.controlador.utils.OwnFile;
import com.example.models.IEmpresa;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class TestConsola {
    private Scanner sc = new Scanner(System.in);
    private ManejoArchivos controller = new ManejoArchivos();

    private IEmpresa empresa;

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

    public void menu(){
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
                this.getClass().getMethod("menuOpcion"+opcion).invoke(this);
                /*
                Se encarga de llamar de manera dinámica, el metodo solicitado de acuerdo a la opción elegida
                Sería equivalente a...
                this.opcion1
                this.opcion2
                 */
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.err.println("La opción ingresada no es correcta");
            }
        } while(opcion!=0);
    }

    public void menuOpcion1(){
        int opcion;

        System.out.print("""
                
                Ingresar clientes
                \t1. Seleccionar archivo clientes
                \t0. Regresar al menú anterior
                \t""");

        opcion=sc.nextInt();

        if (opcion==1) {
            System.out.print("""
                    
                    Ingrese el nombre del archivo: """);

            String fileName = sc.nextLine();

            File clientFile = new File("saved/clients", fileName);

            OwnFile clientOwnFile = new OwnFile(clientFile);

            controller.loadClients(clientOwnFile);
        }


    }

    public void menuOpcion2() {

    }
}

