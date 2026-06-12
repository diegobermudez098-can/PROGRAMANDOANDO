package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio22 {
    public void ejecutar() {
        int[] nums = {10, 25, 3, 47, 8, 99, 14, 56, 31, 72};
        StringBuilder sb = new StringBuilder("Elementos del arreglo:\n");
        for (int i = 0; i < nums.length; i++) sb.append("nums[").append(i).append("] = ").append(nums[i]).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
