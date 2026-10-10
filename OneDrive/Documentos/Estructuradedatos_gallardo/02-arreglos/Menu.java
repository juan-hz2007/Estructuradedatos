package mx.edu.uttt.menu;

import javax.swing.*;

public class Menu {

    public static String menuPrincipal(){

        String opciones =
                "======================= ESTRUCTURA DE DATOS ======================\n\n"+
                        "1) Arreglos\n"+
                        "2) Listas\n"+
                        "3) Pilas\n"+
                        "4) Colas\n"+
                        "5) Arboles\n"+
                        "6) Salir\n"+
                        "7) Seleccione una opcion";

        return JOptionPane.showInputDialog(opciones);


    }
    public static String MenuArreglos(){
        String opciones =
                "======================= ARREGLOS ======================\n\n"+
                        "1) Vectores\n"+
                        "2) Matrices\n"+
                        "0) Regresar\n"+
                        "Seleccione una opcion: ";

        return JOptionPane.showInputDialog(opciones);
    }

    public static String menuVectores(){
        String opciones =
                "======================= VECTORES ======================\n\n"+
                        "1) Sumar Elementos\n"+
                        "2) Llenar Vector\n"+
                        "3) Imprimir\n"+
                        "0) Regresar\n"+
                        "Seleccione una opcion: ";

        return JOptionPane.showInputDialog(opciones);


    }

    public static String menuMatrices(){
        String opciones =
                "======================= Matrices ======================\n\n"+
                        "1) Reserva de Asientos\n"+
                        "2) Acumulado de Ventas\n"+
                        "3) Matriz identidad\n"+
                        "4) Diagonal Principal\n"+
                        "5) Transposicion\n"+
                        "6) Rotacion\n"+
                        "0) Regresar\n"+
                        "Seleccione una opcion: ";

        return JOptionPane.showInputDialog(opciones);
    }

    //Menu Listas
    public static String menuListas(){
        return "";

    }

    public static String menuColas(){
        return "";

    }

    public static String menuPilas(){
        return "";

    }

    public static String menuArboles(){
        return "";

    }

}
