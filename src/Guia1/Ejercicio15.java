package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio15 {
    public void ejecutar() {
        int suma = 0;
        for (int i = 1; i <= 100; i++) suma += i;
        JOptionPane.showMessageDialog(null, "Suma del 1 al 100: " + suma);
    }
}
