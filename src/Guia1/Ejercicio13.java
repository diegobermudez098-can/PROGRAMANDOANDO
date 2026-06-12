package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio13 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Numeros pares del 1 al 100:\n");
        for (int i = 2; i <= 100; i += 2) sb.append(i).append(" ");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
