package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio11 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Numeros del 1 al 50:\n");
        for (int i = 1; i <= 50; i++) sb.append(i).append(" ");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
