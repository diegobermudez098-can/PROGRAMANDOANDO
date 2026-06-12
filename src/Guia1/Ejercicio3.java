package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio3 {
    public void ejecutar() {
        try {
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad:"));
            if (edad < 0)       JOptionPane.showMessageDialog(null, "Edad invalida.");
            else if (edad >= 18) JOptionPane.showMessageDialog(null, "Puede ingresar.");
            else                JOptionPane.showMessageDialog(null, "Acceso denegado.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
        }
    }
}
