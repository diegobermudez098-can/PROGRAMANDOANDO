package Catalogo_De_VideoJuegos.dao;

import java.sql.*;

import Catalogo_De_VideoJuegos.db.ConexionDB;
import Catalogo_De_VideoJuegos.modelo.Usuario;

public class UsuarioDAO {

    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS usuarios (
                id       INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL
            )
            """;

        try (Connection con = ConexionDB.conectar();
             Statement st = con.createStatement()) {

            st.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error creando tabla usuarios: " + e.getMessage());
        }
    }

    public static void insertarSiNoExiste(String username, String password) {
        String check  = "SELECT id FROM usuarios WHERE username = ?";
        String insert = "INSERT INTO usuarios (username, password) VALUES (?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement psCheck = con.prepareStatement(check)) {

            psCheck.setString(1, username.trim());
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                try (PreparedStatement psIns = con.prepareStatement(insert)) {

                    psIns.setString(1, username.trim());
                    psIns.setString(2, password.trim());

                    int filas = psIns.executeUpdate();
                    System.out.println("Usuario insertado: " + username + " | filas: " + filas);
                }
            } else {
                System.out.println("Usuario ya existe: " + username);
            }

        } catch (SQLException e) {
            System.out.println("Error insertando usuario: " + e.getMessage());
        }
    }

    public static Usuario autenticar(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error en autenticación: " + e.getMessage());
        }

        return null;
    }
}