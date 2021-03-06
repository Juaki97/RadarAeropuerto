package me.jojigarcia.controller;

import me.jojigarcia.model.Avion;
import me.jojigarcia.model.ListaAviones;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by joaquinjimenezgarcia on 4/5/17.
 */
public class RadarApp {
    ListaAviones listaAviones;

    public RadarApp(){
        listaAviones = new ListaAviones();
    }

    public void run(){
        int option;

        while ((option = showMenu())!= 0){
            switch (option) {
                case 1:
                    listaAviones.sumarAvion(leerAvion());
                    break;
                case 2:
                    if (listaAviones.longitud()>0){
                        listaAviones.mostrarAviones();
                    }
                    break;
                case 3:
                    if (listaAviones.longitud()>0){
                        listaAviones.eliminarAvion(leerCodigo());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public String leerCodigo(){
        Scanner input = new Scanner(System.in);
        String codVuelo;

        System.out.println("Inserte el código del vuelo: ");
        codVuelo = input.next();

        return codVuelo;
    }

    public Avion leerAvion(){
        Scanner input = new Scanner (System.in);
        String codVuelo;
        String aerolinea;
        int velocidad;
        Date fechaHora;
        double distancia;
        Avion avion;

        do {
            System.out.println("Inserte código de vuelo: ");
            codVuelo = input.next();
        }while (codVuelo.equals(""));

        do {
            System.out.println("Inserte aerolínea: ");
            aerolinea = input.next();
        }while (aerolinea.equals(""));

        do {
            System.out.println("Velocidad de la aeronave: ");
            velocidad = input.nextInt();
        }while (velocidad <= 0);

        fechaHora = new Date();

        do {
            System.out.println("Distancia a pista: ");
            distancia = input.nextDouble();
        }while (distancia <= 0.0);

        avion = new Avion(codVuelo,aerolinea,velocidad,fechaHora,distancia);

        return avion;
    }

    public int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("****************************");
        System.out.println("* 1. Registrar aeronave    *");
        if (listaAviones.longitud()>0) {
            System.out.println("* 2. Aeronaves registradas *");
            System.out.println("* 3. Explotar avión        *");
        }
        System.out.println("* 0. Salir                 *");
        System.out.println("****************************");

        System.out.println("Opción: ");
        option = input.nextInt();

        return option;
    }
}
