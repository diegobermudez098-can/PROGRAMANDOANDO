package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio28 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Primeros 20 numeros y su cubo:\n");
        sb.append(String.format("%-5s %-10s%n", "N", "N^3"));
        for (int i = 1; i <= 20; i++) sb.append(String.format("%-5d %-10d%n", i, (long)(i*i*i)));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
