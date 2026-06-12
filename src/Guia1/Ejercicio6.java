package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio6 {
    public void ejecutar() {
        try {
            int nota = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la nota (0-100):"));
            if (nota < 0 || nota > 100) { JOptionPane.showMessageDialog(null, "Nota invalida."); return; }
            String clasificacion;
            if (nota >= 90)      clasificacion = "Excelente";
            else if (nota >= 80) clasificacion = "Bueno";
            else if (nota >= 70) clasificacion = "Aceptable";
            else if (nota >= 60) clasificacion = "Insuficiente";
            else                 clasificacion = "Reprobado";
            JOptionPane.showMessageDialog(null, "Nota: " + nota + " -> " + clasificacion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa una nota valida.");
        }
    }
}
