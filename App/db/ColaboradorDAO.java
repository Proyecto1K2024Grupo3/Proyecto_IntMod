package App.db;

import App.model.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ColaboradorDAO que gestiona el acceso a la base de datos para la entidad Colaborador.
 * Implementa el patrón Singleton para asegurar una única instancia.
 *
 * @author Emilio, Pablo, Sergio
 */
public class ColaboradorDAO {

    // Instancia única de ColaboradorDAO
    private static ColaboradorDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO colaborador (n_usuario, nombre) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM colaborador";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM colaborador WHERE n_usuario = ?";
    private static final String UPDATE_QUERY = "UPDATE colaborador SET nombre = ? WHERE n_usuario = ?";
    private static final String DELETE_QUERY = "DELETE FROM colaborador WHERE n_usuario = ?";
    private static final String TOTAL_COLABORADORES_QUERY = "SELECT COUNT(*) FROM colaborador";

    /**
     * Constructor privado.
     */
    private ColaboradorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Devuelve la instancia única de ColaboradorDAO.
     */
    public static synchronized ColaboradorDAO getInstance() {
        if (instance == null) {
            instance = new ColaboradorDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo colaborador.
     */
    public void insertarColaborador(Colaborador colaborador) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, colaborador.getN_usuario());
            statement.setString(2, colaborador.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los colaboradores.
     */
    public List<Colaborador> obtenerTodosColaboradores() throws SQLException {
        List<Colaborador> colaboradores = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                colaboradores.add(resultSetToColaborador(rs));
            }
        }
        return colaboradores;
    }

    /**
     * Recupera un colaborador por su n_usuario.
     */
    public Colaborador obtenerColaboradorPorUsuario(String nUsuario) throws SQLException {
        Colaborador colaborador = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setString(1, nUsuario);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                colaborador = resultSetToColaborador(rs);
            }
        }
        return colaborador;
    }

    /**
     * Actualiza un colaborador.
     */
    public void actualizarColaborador(Colaborador colaborador) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, colaborador.getNombre());
            statement.setString(2, colaborador.getN_usuario());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un colaborador por su n_usuario.
     */
    public void eliminarColaboradorPorUsuario(String nUsuario) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, nUsuario);
            statement.executeUpdate();
        }
    }

    /**
     * Devuelve el número total de colaboradores.
     */
    public int contarColaboradores() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_COLABORADORES_QUERY)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        }
        return total;
    }

    /**
     * Convierte un ResultSet en un objeto Colaborador.
     */
    private Colaborador resultSetToColaborador(ResultSet rs) throws SQLException {
        return new Colaborador(
                rs.getString("n_usuario"),
                rs.getString("nombre")
        );
    }
}
