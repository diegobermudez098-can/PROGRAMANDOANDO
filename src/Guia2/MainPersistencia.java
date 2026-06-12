package Guia2;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainPersistencia {

    private static final String URL = "jdbc:sqlite:guia2_datos.db";

    private Connection conectar() throws SQLException {
        try { Class.forName("org.sqlite.JDBC"); }
        catch (ClassNotFoundException e) {
            throw new SQLException("Driver SQLite no encontrado. Agrega sqlite-jdbc.jar a /lib");
        }
        return DriverManager.getConnection(URL);
    }

    private void crearTablasSiNoExisten() {
        String sql = "CREATE TABLE IF NOT EXISTS datos (id INTEGER PRIMARY KEY AUTOINCREMENT, valor TEXT NOT NULL)";
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error creando tabla: " + e.getMessage());
        }
    }

    public void ejecutar() {
        crearTablasSiNoExisten();
        boolean volver = false;
        while (!volver) {
            String op = JOptionPane.showInputDialog(null,
                "=== Persistencia con Base de Datos ===\n\n" +
                "1. Guardar dato\n" +
                "2. Consultar datos\n" +
                "0. Volver\n\nSelecciona:");

            if (op == null || op.equals("0")) {
                volver = true;
            } else {
                switch (op) {
                    case "1": guardarDato();    break;
                    case "2": consultarDatos(); break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            }
        }
    }

    private void guardarDato() {
        try (Connection con = conectar()) {
            String valor = JOptionPane.showInputDialog("Ingresa el valor a guardar:");
            if (valor == null || valor.trim().isEmpty()) return;
            valor = valor.trim();

            String sql = "INSERT INTO datos (valor) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dato guardado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de BD: " + e.getMessage());
        }
    }

    private void consultarDatos() {
        try (Connection con = conectar()) {
            String sql = "SELECT id, valor FROM datos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            StringBuilder sb = new StringBuilder("=== Datos guardados ===\n");
            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(" | Valor: ").append(rs.getString("valor")).append("\n");
            }
            if (!hayDatos) sb.append("(ningún dato registrado aún)");
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de BD: " + e.getMessage());
        }
    }
}