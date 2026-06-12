package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio24 {
    public void ejecutar() {
        int[] nums = {10, 25, 3, 47, 8, 99, 14, 56, 31, 72};
        int mayor = nums[0];
        for (int i = 1; i < nums.length; i++) if (nums[i] > mayor) mayor = nums[i];
        JOptionPane.showMessageDialog(null, "El numero mayor del arreglo es: " + mayor);
    }
}
