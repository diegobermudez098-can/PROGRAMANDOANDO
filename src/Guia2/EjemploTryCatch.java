package Guia2;

import javax.swing.JOptionPane;

public class EjemploTryCatch {
    public void ejecutar() {
        try {
            String input = JOptionPane.showInputDialog("Ingresa un número entero:");
            if (input == null) throw new NullPointerException("Cancelado por el usuario.");
            int numero = Integer.parseInt(input);
            JOptionPane.showMessageDialog(null, "Número ingresado: " + numero);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: formato de número inválido.\n" + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            System.out.println("EjemploTryCatch finalizado.");
        }
    }
}
