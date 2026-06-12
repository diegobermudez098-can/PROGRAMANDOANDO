package Guia2;
import javax.swing.JOptionPane;

public class Ejercicio4 {
    public void ejecutar() {
        String[] nombres = {"Ana", "Luis", "Maria", "Pedro", "Sofia"};
        try {
            int i = Integer.parseInt(JOptionPane.showInputDialog("Posicion (0 a 4):"));
            JOptionPane.showMessageDialog(null, "Nombre: " + nombres[i]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero entero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Posicion invalida. Solo existen posiciones 0 a 4.");
        }
    }
}
