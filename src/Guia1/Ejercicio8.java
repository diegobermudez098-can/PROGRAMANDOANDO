package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio8 {
    public void ejecutar() {
        try {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor de la compra: $"));
            double pct = 0;
            if (valor > 500000) pct = 0.20;
            else if (valor > 200000) pct = 0.15;
            else if (valor > 100000) pct = 0.10;
            double descuento = valor * pct;
            double total = valor - descuento;
            JOptionPane.showMessageDialog(null,
                "Valor original:  $" + valor + "\n" +
                "Descuento (" + (int)(pct*100) + "%): $" + descuento + "\n" +
                "Total a pagar:   $" + total);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un valor valido.");
        }
    }
}
