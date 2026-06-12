package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio16 {
    public void ejecutar() {
        int suma = 0;
        for (int i = 1; i <= 50; i += 2) suma += i;
        JOptionPane.showMessageDialog(null, "Suma de impares del 1 al 50: " + suma);
    }
}
