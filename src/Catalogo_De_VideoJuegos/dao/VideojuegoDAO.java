package Catalogo_De_VideoJuegos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Catalogo_De_VideoJuegos.db.ConexionDB;
import Catalogo_De_VideoJuegos.modelo.Videojuego;


public class VideojuegoDAO {

    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS videojuegos (
                id             INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo         TEXT    NOT NULL,
                genero         TEXT    NOT NULL,
                desarrollador  TEXT    NOT NULL,
                anio           INTEGER NOT NULL,
                precio         REAL    NOT NULL
            )
            """;
        try (Connection con = ConexionDB.conectar();
             Statement  st  = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creando tabla videojuegos: " + e.getMessage());
        }
    }

    public static boolean agregar(Videojuego v) {
        String sql = """
            INSERT INTO videojuegos (titulo, genero, desarrollador, anio, precio)
            VALUES (?, ?, ?, ?, ?)
            """;
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getTitulo());
            ps.setString(2, v.getGenero());
            ps.setString(3, v.getDesarrollador());
            ps.setInt   (4, v.getAnio());
            ps.setDouble(5, v.getPrecio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }
    }

    public static List<Videojuego> obtenerTodos() {
        List<Videojuego> lista = new ArrayList<>();
        String sql = "SELECT * FROM videojuegos ORDER BY id";
        try (Connection con = ConexionDB.conectar();
             Statement  st  = con.createStatement();
             ResultSet  rs  = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Videojuego(
                    rs.getInt   ("id"),
                    rs.getString("titulo"),
                    rs.getString("genero"),
                    rs.getString("desarrollador"),
                    rs.getInt   ("anio"),
                    rs.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return lista;
    }

    public static Videojuego obtenerPorId(int id) {
        String sql = "SELECT * FROM videojuegos WHERE id = ?";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Videojuego(
                    rs.getInt   ("id"),
                    rs.getString("titulo"),
                    rs.getString("genero"),
                    rs.getString("desarrollador"),
                    rs.getInt   ("anio"),
                    rs.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por ID: " + e.getMessage());
        }
        return null;
    }

    public static boolean actualizar(Videojuego v) {
        String sql = """
            UPDATE videojuegos
            SET titulo = ?, genero = ?, desarrollador = ?, anio = ?, precio = ?
            WHERE id = ?
            """;
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getTitulo());
            ps.setString(2, v.getGenero());
            ps.setString(3, v.getDesarrollador());
            ps.setInt   (4, v.getAnio());
            ps.setDouble(5, v.getPrecio());
            ps.setInt   (6, v.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminar(int id) {
        String sql = "DELETE FROM videojuegos WHERE id = ?";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public static void insertarSiNoExiste(String titulo, String genero,
                                           String desarrollador, int anio, double precio) {
        String check = "SELECT id FROM videojuegos WHERE titulo = ?";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(check)) {
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                agregar(new Videojuego(titulo, genero, desarrollador, anio, precio));
            }
        } catch (SQLException e) {
            System.out.println("Error verificando dato inicial: " + e.getMessage());
        }
    }
}
