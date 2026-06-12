package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio21 {
    public void ejecutar() {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Numero para calcular factorial:"));
            long factorial = 1;
            for (int i = 1; i <= n; i++) factorial *= i;
            JOptionPane.showMessageDialog(null, "Factorial de " + n + " = " + factorial);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
        }
    }
}
