package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio26 {
    public void ejecutar() {
        try {
            int[] nums = {5, 3, 8, 5, 2, 5, 9, 1, 5, 4};
            int buscar = Integer.parseInt(JOptionPane.showInputDialog("Numero a buscar en el arreglo:"));
            int contador = 0;
            for (int i = 0; i < nums.length; i++) if (nums[i] == buscar) contador++;
            JOptionPane.showMessageDialog(null, "El numero " + buscar + " aparece " + contador + " veces.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
        }
    }
}
