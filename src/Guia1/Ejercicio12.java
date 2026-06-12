package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio12 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Numeros del 50 al 1:\n");
        for (int i = 50; i >= 1; i--) sb.append(i).append(" ");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
