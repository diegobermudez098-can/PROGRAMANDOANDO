package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio25 {
    public void ejecutar() {
        int[] nums = {10, 25, 3, 47, 8, 99, 14, 56, 31, 72};
        int menor = nums[0];
        for (int i = 1; i < nums.length; i++) if (nums[i] < menor) menor = nums[i];
        JOptionPane.showMessageDialog(null, "El numero menor del arreglo es: " + menor);
    }
}
