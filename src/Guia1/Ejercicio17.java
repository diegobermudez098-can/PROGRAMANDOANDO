package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio17 {
    public void ejecutar() {
        StringBuilder sb = new StringBuilder("Tabla del 7:\n");
        for (int i = 1; i <= 10; i++) sb.append("7 x ").append(i).append(" = ").append(7*i).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
