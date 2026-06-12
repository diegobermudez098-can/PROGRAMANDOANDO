package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio9 {
    public void ejecutar() {
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String contrasena = JOptionPane.showInputDialog("Contrasena:");
        if (usuario != null && contrasena != null &&
            usuario.equals("admin") && contrasena.equals("1234"))
            JOptionPane.showMessageDialog(null, "Bienvenido.");
        else
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
    }
}
