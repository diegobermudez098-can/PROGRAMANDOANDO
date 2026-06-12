package Guia2;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public void ejecutar() {
        try {
            double c = Double.parseDouble(JOptionPane.showInputDialog("Temperatura en Celsius:"));
            double f = (c * 9.0 / 5) + 32;
            JOptionPane.showMessageDialog(null, c + "C = " + f + "F");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido. Ejemplo: 36.5");
        }
    }
}
