package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio4 {
    public void ejecutar() {
        try {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Primer numero:"));
            String op = JOptionPane.showInputDialog("Operador (+, -, *, /):");
            double b = Double.parseDouble(JOptionPane.showInputDialog("Segundo numero:"));
            double resultado = 0;
            switch (op) {
                case "+": resultado = a + b; break;
                case "-": resultado = a - b; break;
                case "*": resultado = a * b; break;
                case "/":
                    if (b == 0) { JOptionPane.showMessageDialog(null, "Error: division entre cero."); return; }
                    resultado = a / b; break;
                default: JOptionPane.showMessageDialog(null, "Operador no valido."); return;
            }
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa numeros validos.");
        }
    }
}
