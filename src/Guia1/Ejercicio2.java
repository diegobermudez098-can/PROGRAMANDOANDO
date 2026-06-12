package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public void ejecutar() {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero entero:"));
            if (n % 2 == 0) JOptionPane.showMessageDialog(null, n + " es Par.");
            else            JOptionPane.showMessageDialog(null, n + " es Impar.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
        }
    }
}
