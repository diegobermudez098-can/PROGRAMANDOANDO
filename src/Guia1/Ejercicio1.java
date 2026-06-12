package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio1 {
    public void ejecutar() {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero entero:"));
            if (n > 0)      JOptionPane.showMessageDialog(null, n + " es Positivo.");
            else if (n < 0) JOptionPane.showMessageDialog(null, n + " es Negativo.");
            else            JOptionPane.showMessageDialog(null, "El numero es Cero.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
        }
    }
}
