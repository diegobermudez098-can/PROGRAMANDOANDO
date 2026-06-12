import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL      = "jdbc:mysql://localhost:3306/programandoando";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public static void cerrarConexion(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}
