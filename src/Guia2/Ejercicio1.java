package Guia2;
import javax.swing.JOptionPane;

public class Ejercicio1 {
    public void ejecutar() {
        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Dividendo:"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Divisor:"));
            JOptionPane.showMessageDialog(null, "Resultado: " + (a / b));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ingresa solo numeros enteros.");
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Error: no se puede dividir entre cero.");
        }
    }
}
