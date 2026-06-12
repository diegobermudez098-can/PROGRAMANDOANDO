package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio18 {
    public void ejecutar() {
        for (int i = 1; i <= 10; i++) {
            StringBuilder sb = new StringBuilder("Tabla del " + i + ":\n");
            for (int j = 1; j <= 10; j++) sb.append(i).append(" x ").append(j).append(" = ").append(i*j).append("\n");
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
