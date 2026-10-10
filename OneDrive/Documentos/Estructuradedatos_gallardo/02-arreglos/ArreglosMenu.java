package mx.edu.uttt.arreglos;

import mx.edu.uttt.arreglos.vectores.Vectores;
import mx.edu.uttt.menu.Menu;

import javax.swing.*;

public class ArreglosMenu {
    private static Vectores objVector;

    private static void inicializar() {
        int tamanio = 0;
        do {
            try {
                tamanio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del arreglo"));
                objVector = new Vectores(tamanio);
                return;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "La fila debe ser un numero");
            }
        } while (true);

    }


    public static void mostrar() {
        String opcion;



        do {
            opcion = Menu.MenuArreglos();
            switch (opcion){
                case "1":
                    menuVectores();
                    break;

                case "2":
                    menuMatrices();
                    break;

                case "0":
                    return;

                default:
                    JOptionPane.showMessageDialog(null,"Opcion no valida");

            }

        }while (true);

    }

    public static int [] obtenerVector (){
        int tamanio = objVector.obtenerTamanio();
        int vector [] = new int[tamanio];
        llenarVector(vector);
        return vector;

    }

    private static void llenarVector(int [] vector){
        int valor=0;

        for (int i = 0; i < vector.length; i++) {
            do {
                try {
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor "+(i+1)));
                    vector[i] = valor;
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La fila debe ser un numero");
                }
            } while (true);
        }

    }

    public static void menuVectores(){
        String opcion;
         inicializar();
        do {
            opcion = Menu.menuVectores();
            switch (opcion){
                case "1":
                    JOptionPane.showMessageDialog(null,objVector.sumarValores());

                case "2":
                    objVector.llenarVector(obtenerVector());

                case "3":
                    JOptionPane.showMessageDialog(null,objVector.imprimir());
                    break;

                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no valida");



            }
        }while (true);

    }

    public static void menuMatrices(){
        String opcion;

        do {
            opcion = Menu.menuMatrices();
            switch (opcion){
                case "1":
                    JOptionPane.showMessageDialog(null,"Llenar Matriz");
                    break;

                case "0":
                    return;

                default:
                    JOptionPane.showMessageDialog(null,"Opcion no valida");
            }

        }while (true);


    }


}
