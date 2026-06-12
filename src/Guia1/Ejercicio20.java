package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio20 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Divisibles entre 3 Y entre 5 (1-100):\n");
        for (int i = 1; i <= 100; i++) if (i % 3 == 0 && i % 5 == 0) sb.append(i).append(" ");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
