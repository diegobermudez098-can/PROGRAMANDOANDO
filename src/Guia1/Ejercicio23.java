package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio23 {
    public void ejecutar() {
        int[] nums = {10, 25, 3, 47, 8, 99, 14, 56, 31, 72};
        int suma = 0;
        for (int i = 0; i < nums.length; i++) suma += nums[i];
        JOptionPane.showMessageDialog(null, "Suma de todos los elementos: " + suma);
    }
}
