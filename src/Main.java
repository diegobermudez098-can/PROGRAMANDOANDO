import Guia1.Guia1Main;
import Guia2.Guia2Main;

import javax.swing.JOptionPane;

import Catalogo_De_VideoJuegos.Guia3Main;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(null,
                "╔══════════════════════════╗\n" +
                "║     ProgramandoAndo      ║\n" +
                "╚══════════════════════════╝\n\n" +
                "1. Guía 1 — Condicionales y Ciclos\n" +
                "2. Guía 2 — Try Catch con JOptionPane\n" +
                "3. Guía 3 — Sistema de Videojuegos\n" +
                "0. Salir\n\n" +
                "Selecciona una opción:");

            if (opcion == null || opcion.equals("0")) {
                salir = true;
            } else if (opcion.equals("1")) {
                new Guia1Main().menu();
            } else if (opcion.equals("2")) {
                new Guia2Main().menu();
            } else if (opcion.equals("3")) {
                new Guia3Main().iniciar();
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
    }
}
