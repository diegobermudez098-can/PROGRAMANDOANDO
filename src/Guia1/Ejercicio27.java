package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio27 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Cuadrado 6x6:\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) sb.append("* ");
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
