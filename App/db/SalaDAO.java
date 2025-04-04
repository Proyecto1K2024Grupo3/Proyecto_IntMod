package App.db;

import App.model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase SalaDAO que gestiona el acceso a la base de datos para la entidad Sala.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class SalaDAO {

    // Instancia única de PersonaDAO
    private static SalaDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO sala (n_sala, tamanyo) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM sala";
    private static final String SELECT_BY_NSALA_QUERY = "SELECT * FROM sala WHERE n_sala = ?";
    private static final String UPDATE_QUERY = "UPDATE sala SET tamanyo = ? WHERE n_sala = ?";
    private static final String DELETE_QUERY = "DELETE FROM sala WHERE n_sala = ?";
    private static final String TOTAL_SALAS_QUERY = "SELECT COUNT(*) FROM sala";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private SalaDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de SalaDAO.
     */
    public static synchronized SalaDAO getInstance() {
        if (instance == null) {
            instance = new SalaDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva sala en la base de datos.
     * @param sala Objeto Sala a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertSala(Sala sala) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, sala.getN_sala());
            statement.setInt(2, sala.getTamanyo());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las salas almacenadas en la base de datos.
     * @return Lista de objetos Sala.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Sala> getAllSalas() throws SQLException {
        List<Sala> salas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                salas.add(resultSetToSalas(resultSet));
            }
        }
        return salas;
    }

    /**
     * Obtiene una sala a partir de su número de sala.
     * @param n_sala Identificador único de la persona.
     * @return Objeto Sala si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Sala getSalaByNSala(int n_sala) throws SQLException {
        Sala sala = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NSALA_QUERY)) {
            statement.setInt(1, n_sala);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sala = resultSetToSalas(resultSet);
            }
        }
        return sala;
    }

    /**
     * Actualiza los datos de una sala en la base de datos.
     * @param sala Objeto Sala con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void UpdateSala(Sala sala) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, sala.getN_sala());
            statement.setInt(2, sala.getTamanyo());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una sala de la base de datos por su número de sala.
     * @param n_sala Identificador único de la sala a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteSalaByNSala(int n_sala) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, n_sala);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Sala.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Sala con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Sala resultSetToSalas(ResultSet resultSet) throws SQLException {
        return new Sala(
                resultSet.getInt("n_Sala"),
                resultSet.getInt("tamanyo"));
    }

    /**
     * Obtiene el total de salas almacenadas en la base de datos.
     * @return Número total de salas.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalSalas() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_SALAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
