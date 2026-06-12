package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio7 {
    public void ejecutar() {
        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Primer numero:"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Segundo numero:"));
            int c = Integer.parseInt(JOptionPane.showInputDialog("Tercer numero:"));
            String msg;
            if (a == b && b == c)       msg = "Los tres son iguales: " + a;
            else if (a == b && a > c)   msg = "Empate entre " + a + " y " + b;
            else if (a == c && a > b)   msg = "Empate entre " + a + " y " + c;
            else if (b == c && b > a)   msg = "Empate entre " + b + " y " + c;
            else if (a > b && a > c)    msg = "El mayor es: " + a;
            else if (b > a && b > c)    msg = "El mayor es: " + b;
            else                        msg = "El mayor es: " + c;
            JOptionPane.showMessageDialog(null, msg);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa numeros validos.");
        }
    }
}
