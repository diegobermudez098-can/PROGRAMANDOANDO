package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio14 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Numeros impares del 1 al 100 (while):\n");
        int i = 1;
        while (i <= 100) { sb.append(i).append(" "); i += 2; }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
