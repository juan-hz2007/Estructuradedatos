package mx.edu.uttt.app;
import javax.swing.*;
import mx.edu.uttt.arreglos.ArreglosMenu;
import mx.edu.uttt.menu.Menu;

public class App {
    static void main(String[] args) {
       // iniciar();
    }


    public static void iniciar(){
    String opcion;
    do {
        opcion = Menu.menuPrincipal();
        switch (opcion){
            case "1":
                ArreglosMenu.mostrar();
                break;

            case "2":
                JOptionPane.showInputDialog(null,"Listas");
                break;

            case "3":
                JOptionPane.showInputDialog(null,"Pilas");
                break;

            case "4":
                JOptionPane.showInputDialog(null,"Colas");
                break;

            case "5":
                JOptionPane.showInputDialog(null,"Arboles");
                break;

            case "0":
                JOptionPane.showMessageDialog(null,"Programa Terminado");
                return;
            default:
                JOptionPane.showMessageDialog(null,"Opcion no valida");
        }
    }while (true);

    }
}
