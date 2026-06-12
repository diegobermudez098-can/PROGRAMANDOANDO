package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio29 {
    public void ejecutar() {
        String texto = JOptionPane.showInputDialog("Ingresa una cadena de texto:");
        if (texto == null) return;
        StringBuilder sb = new StringBuilder("Caracteres uno por linea:\n");
        for (int i = 0; i < texto.length(); i++) sb.append(texto.charAt(i)).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
