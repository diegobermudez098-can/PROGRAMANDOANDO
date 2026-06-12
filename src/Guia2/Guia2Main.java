package Guia2;

import javax.swing.JOptionPane;

public class Guia2Main {
    public void menu() {
        boolean volver = false;
        while (!volver) {
            String op = JOptionPane.showInputDialog(null,
                "=== Guia 2: Try Catch con JOptionPane ===\n\n" +
                "1. Division entera basica\n" +
                "2. Conversion de temperatura\n" +
                "3. Calculadora de IMC\n" +
                "4. Acceso a arreglo por indice\n" +
                "5. Validacion con bucle (retry)\n" +
                "6. Cancelacion del dialogo (NullPointerException)\n\n" +
                "0. Volver\n\nSelecciona:");

            if (op == null || op.equals("0")) {
                volver = true;
            } else {
                switch (op) {
                    case "1": new Ejercicio1().ejecutar(); break;
                    case "2": new Ejercicio2().ejecutar(); break;
                    case "3": new Ejercicio3().ejecutar(); break;
                    case "4": new Ejercicio4().ejecutar(); break;
                    case "5": new Ejercicio5().ejecutar(); break;
                    case "6": new Ejercicio6().ejecutar(); break;
                    default: JOptionPane.showMessageDialog(null, "Opcion no valida.");
                }
            }
        }
    }
}
