package Catalogo_De_VideoJuegos;

import javax.swing.JOptionPane;

import Catalogo_De_VideoJuegos.dao.UsuarioDAO;
import Catalogo_De_VideoJuegos.dao.VideojuegoDAO;
import Catalogo_De_VideoJuegos.modelo.Usuario;
import Catalogo_De_VideoJuegos.modelo.Videojuego;

import java.util.List;

public class Guia3Main {

    private Usuario usuarioActivo = null;

    public void iniciar() {

        inicializarBD();

        boolean salirApp = false;

        while (!salirApp) {

            boolean autenticado = login();
            if (!autenticado) {
                JOptionPane.showMessageDialog(null,
                    "Demasiados intentos fallidos. El sistema se cerrará.",
                    "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean cerrarSesion = menuPrincipal();
            if (!cerrarSesion) {
                salirApp = true;
            }

            usuarioActivo = null;
        }

        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
    }

    private boolean login() {
        final int MAX_INTENTOS = 3;

        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {

            String user = JOptionPane.showInputDialog(null,
                "╔══ CATÁLOGO DE VIDEOJUEGOS ══╗\n\n" +
                "Intento " + intento + " de " + MAX_INTENTOS + "\n\n" +
                "Usuario:",
                "Login", JOptionPane.PLAIN_MESSAGE);

            if (user == null) return false;

            String pass = JOptionPane.showInputDialog(null,
                "Contraseña para: " + user,
                "Contraseña", JOptionPane.PLAIN_MESSAGE);

            if (pass == null) return false;

            Usuario u = UsuarioDAO.autenticar(user.trim(), pass.trim());

            if (u != null) {
                usuarioActivo = u;

                JOptionPane.showMessageDialog(null,
                    "Bienvenido, " + u.getUsername(),
                    "Acceso correcto",
                    JOptionPane.INFORMATION_MESSAGE);

                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                    "Credenciales incorrectas. Intento " + intento + " fallido.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        }

        return false;
    }

    private boolean menuPrincipal() {

        while (true) {

            String op = JOptionPane.showInputDialog(null,
                "╔══ CATÁLOGO DE VIDEOJUEGOS ══╗\n" +
                "Usuario: " + usuarioActivo.getUsername() + "\n\n" +
                "1. Agregar videojuego\n" +
                "2. Ver videojuegos\n" +
                "3. Actualizar videojuego\n" +
                "4. Eliminar videojuego\n" +
                "5. Cerrar sesión\n" +
                "0. Salir\n\n" +
                "Opción:",
                "Menú", JOptionPane.PLAIN_MESSAGE);

            if (op == null || op.equals("0")) return false;

            switch (op.trim()) {
                case "1" -> agregar();
                case "2" -> verTodos();
                case "3" -> actualizar();
                case "4" -> eliminar();
                case "5" -> {
                    JOptionPane.showMessageDialog(null,
                        "Sesión cerrada");
                    return true;
                }
                default -> JOptionPane.showMessageDialog(null,
                    "Opción inválida");
            }
        }
    }

    private void agregar() {

        String titulo = pedirTexto("Título:");
        if (titulo == null) return;

        String genero = pedirTexto("Género:");
        if (genero == null) return;

        String dev = pedirTexto("Desarrollador:");
        if (dev == null) return;

        int anio = pedirEntero("Año:", 1970, 2030);
        if (anio == -1) return;

        double precio = pedirDecimal("Precio:");
        if (precio == -1) return;

        Videojuego v = new Videojuego(titulo, genero, dev, anio, precio);

        VideojuegoDAO.agregar(v);

        JOptionPane.showMessageDialog(null,
            "Videojuego agregado correctamente");
    }

    private void verTodos() {

        List<Videojuego> lista = VideojuegoDAO.obtenerTodos();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No hay videojuegos registrados");
            return;
        }

        String texto = "🎮 CATÁLOGO DE VIDEOJUEGOS 🎮\n\n";

        texto += String.format("%-4s %-20s %-10s %-15s %-6s %-8s%n",
                "ID", "TÍTULO", "GÉNERO", "DEV", "AÑO", "PRECIO");

        texto += "------------------------------------------------------------\n";

        for (Videojuego v : lista) {
            texto += String.format("%-4d %-20s %-10s %-15s %-6d $%.2f%n",
                    v.getId(),
                    cortar(v.getTitulo(), 20),
                    cortar(v.getGenero(), 10),
                    cortar(v.getDesarrollador(), 15),
                    v.getAnio(),
                    v.getPrecio());
        }

        JOptionPane.showMessageDialog(null,
            texto,
            "Catálogo",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizar() {

        verTodos();

        int id = pedirEntero("ID a actualizar:", 1, 99999);
        if (id == -1) return;

        Videojuego v = VideojuegoDAO.obtenerPorId(id);

        if (v == null) {
            JOptionPane.showMessageDialog(null,
                "No encontrado");
            return;
        }

        v.setTitulo(pedirTextoOpcional("Título:", v.getTitulo()));
        v.setGenero(pedirTextoOpcional("Género:", v.getGenero()));
        v.setDesarrollador(pedirTextoOpcional("Dev:", v.getDesarrollador()));
        v.setAnio(pedirEnteroOpcional("Año:", v.getAnio()));
        v.setPrecio(pedirDecimalOpcional("Precio:", v.getPrecio()));

        VideojuegoDAO.actualizar(v);

        JOptionPane.showMessageDialog(null,
            "Actualizado correctamente");
    }

    private void eliminar() {

        verTodos();

        int id = pedirEntero("ID a eliminar:", 1, 99999);
        if (id == -1) return;

        VideojuegoDAO.eliminar(id);

        JOptionPane.showMessageDialog(null,
            "Eliminado correctamente");
    }

    private void inicializarBD() {

        UsuarioDAO.crearTabla();
        VideojuegoDAO.crearTabla();

        UsuarioDAO.insertarSiNoExiste("admin", "admin123");
        UsuarioDAO.insertarSiNoExiste("empleado", "emp456");

        VideojuegoDAO.insertarSiNoExiste("Zelda BOTW", "Aventura", "Nintendo", 2017, 59.99);
        VideojuegoDAO.insertarSiNoExiste("Elden Ring", "RPG", "FromSoftware", 2022, 59.99);
        VideojuegoDAO.insertarSiNoExiste("FIFA 24", "Deportes", "EA Sports", 2023, 69.99);
    }

    private String cortar(String texto, int max) {
        if (texto == null) return "";
        if (texto.length() <= max) return texto;
        return texto.substring(0, max - 3) + "...";
    }

    private String pedirTexto(String msg) {
        String v = JOptionPane.showInputDialog(msg);
        return (v == null || v.isBlank()) ? null : v.trim();
    }

    private String pedirTextoOpcional(String msg, String actual) {
        String v = JOptionPane.showInputDialog(msg + " (" + actual + ")");
        return (v == null || v.isBlank()) ? actual : v.trim();
    }

    private int pedirEntero(String msg, int min, int max) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(msg));
        } catch (Exception e) {
            return -1;
        }
    }

    private int pedirEnteroOpcional(String msg, int actual) {
        try {
            String v = JOptionPane.showInputDialog(msg + " (" + actual + ")");
            return (v == null || v.isBlank()) ? actual : Integer.parseInt(v);
        } catch (Exception e) {
            return actual;
        }
    }

    private double pedirDecimal(String msg) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(msg));
        } catch (Exception e) {
            return -1;
        }
    }

    private double pedirDecimalOpcional(String msg, double actual) {
        try {
            String v = JOptionPane.showInputDialog(msg + " (" + actual + ")");
            return (v == null || v.isBlank()) ? actual : Double.parseDouble(v);
        } catch (Exception e) {
            return actual;
        }
    }
}