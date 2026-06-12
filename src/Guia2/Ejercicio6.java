package Guia2;
import javax.swing.JOptionPane;

public class Ejercicio6 {
    public void ejecutar() {
        try {
            String nombre = JOptionPane.showInputDialog("Escribe tu nombre:");
            JOptionPane.showMessageDialog(null, "Hola, " + nombre.toUpperCase() + "!");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Cancelaste la operacion. El nombre es requerido.");
        }
    }
}
