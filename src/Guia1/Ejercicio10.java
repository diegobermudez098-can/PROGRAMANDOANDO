package Guia1;
import javax.swing.JOptionPane;

public class Ejercicio10 {
    public void ejecutar() {
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso (kg):"));
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura (m):"));
            if (altura == 0) { JOptionPane.showMessageDialog(null, "La altura no puede ser 0."); return; }
            double imc = peso / (altura * altura);
            String clasificacion;
            if (imc < 18.5)      clasificacion = "Bajo peso";
            else if (imc < 25)   clasificacion = "Normal";
            else if (imc < 30)   clasificacion = "Sobrepeso";
            else                 clasificacion = "Obesidad";
            JOptionPane.showMessageDialog(null,
                String.format("IMC: %.2f\nClasificacion: %s", imc, clasificacion));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa valores validos.");
        }
    }
}
