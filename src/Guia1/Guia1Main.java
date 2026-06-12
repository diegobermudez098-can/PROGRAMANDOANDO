package Guia1;

import javax.swing.JOptionPane;

public class Guia1Main {
    public void menu() {
        boolean volver = false;
        while (!volver) {
            String op = JOptionPane.showInputDialog(null,
                "=== Guia 1: Condicionales y Ciclos ===\n\n" +
                "-- CONDICIONALES --\n" +
                "1.  Positivo, Negativo o Cero\n" +
                "2.  Par o Impar\n" +
                "3.  Control de edad\n" +
                "4.  Calculadora con switch\n" +
                "5.  Año bisiesto\n" +
                "6.  Clasificar nota\n" +
                "7.  Mayor de tres numeros\n" +
                "8.  Descuento por compra\n" +
                "9.  Login simulado\n" +
                "10. Calculadora de IMC\n\n" +
                "-- CICLOS --\n" +
                "11. Numeros del 1 al 50\n" +
                "12. Numeros del 50 al 1\n" +
                "13. Pares del 1 al 100\n" +
                "14. Impares del 1 al 100 (while)\n" +
                "15. Suma del 1 al 100\n" +
                "16. Suma impares del 1 al 50\n" +
                "17. Tabla del 7\n" +
                "18. Tablas del 1 al 10\n" +
                "19. Multiplos de 10 entre 1 y 200\n" +
                "20. Divisibles entre 3 y 5\n" +
                "21. Factorial\n" +
                "22. Imprimir arreglo\n" +
                "23. Suma de arreglo\n" +
                "24. Mayor del arreglo\n" +
                "25. Menor del arreglo\n" +
                "26. Contar elemento en arreglo\n" +
                "27. Cuadrado 6x6 asteriscos\n" +
                "28. Cubos del 1 al 20\n" +
                "29. Caracteres de una cadena\n\n" +
                "0.  Volver\n\nSelecciona:");

            if (op == null || op.equals("0")) {
                volver = true;
            } else {
                ejecutar(op);
            }
        }
    }

    private void ejecutar(String op) {
        switch (op) {
            case "1":  new Ejercicio1().ejecutar();  break;
            case "2":  new Ejercicio2().ejecutar();  break;
            case "3":  new Ejercicio3().ejecutar();  break;
            case "4":  new Ejercicio4().ejecutar();  break;
            case "5":  new Ejercicio5().ejecutar();  break;
            case "6":  new Ejercicio6().ejecutar();  break;
            case "7":  new Ejercicio7().ejecutar();  break;
            case "8":  new Ejercicio8().ejecutar();  break;
            case "9":  new Ejercicio9().ejecutar();  break;
            case "10": new Ejercicio10().ejecutar(); break;
            case "11": new Ejercicio11().ejecutar(); break;
            case "12": new Ejercicio12().ejecutar(); break;
            case "13": new Ejercicio13().ejecutar(); break;
            case "14": new Ejercicio14().ejecutar(); break;
            case "15": new Ejercicio15().ejecutar(); break;
            case "16": new Ejercicio16().ejecutar(); break;
            case "17": new Ejercicio17().ejecutar(); break;
            case "18": new Ejercicio18().ejecutar(); break;
            case "19": new Ejercicio19().ejecutar(); break;
            case "20": new Ejercicio20().ejecutar(); break;
            case "21": new Ejercicio21().ejecutar(); break;
            case "22": new Ejercicio22().ejecutar(); break;
            case "23": new Ejercicio23().ejecutar(); break;
            case "24": new Ejercicio24().ejecutar(); break;
            case "25": new Ejercicio25().ejecutar(); break;
            case "26": new Ejercicio26().ejecutar(); break;
            case "27": new Ejercicio27().ejecutar(); break;
            case "28": new Ejercicio28().ejecutar(); break;
            case "29": new Ejercicio29().ejecutar(); break;
            default: JOptionPane.showMessageDialog(null, "Opcion no valida.");
        }
    }
}
