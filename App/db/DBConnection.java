package App.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase DBConnection que gestiona la conexión a la base de datos.
 * Implementa el patrón Singleton para asegurar una única instancia de conexión.
 *
 * @author Emilio, Pablo, Sergio
 */
public class DBConnection {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://proyecto.cp88kmeyiw48.us-east-1.rds.amazonaws.com:3306/ProyectoIntMod";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "SegundaFila?";

    private static Connection connection;

    // Constructor privado para evitar instancias directas
    private DBConnection() {}

    /**
     * Método estático para obtener la instancia única de la conexión.
     * @return La conexión a la base de datos.
     */
    public static Connection getConnection() {
        if (connection == null) {
            // Bloqueo sincronizado para evitar concurrencia
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        // Establecer la conexión
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch ( SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    /**
     * Método para cerrar la conexión a la base de datos.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
