package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio5 {
    public void ejecutar() {
        try {
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un anio:"));
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0))
                JOptionPane.showMessageDialog(null, anio + " ES bisiesto.");
            else
                JOptionPane.showMessageDialog(null, anio + " NO es bisiesto.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un anio valido.");
        }
    }
}
