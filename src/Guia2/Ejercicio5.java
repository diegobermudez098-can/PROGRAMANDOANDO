package Guia2;
import javax.swing.JOptionPane;

public class Ejercicio5 {
    public void ejecutar() {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Numero entre 1 y 100:"));
                if (numero < 1 || numero > 100) throw new IllegalArgumentException("Fuera de rango");
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo numeros enteros. Intenta de nuevo.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "El numero debe estar entre 1 y 100.");
            }
        }
        JOptionPane.showMessageDialog(null, "Numero aceptado: " + numero);
    }
}
