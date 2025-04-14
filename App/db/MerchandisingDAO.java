package App.db;

import App.model.Empleado;
import App.model.Merchandising;
import App.model.Producto;
import App.model.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MerchandisingDAO {

    // Instancia única de MerchandisingDAO
    private static MerchandisingDAO instance;
    // Conexión a la base de datos
    private Connection connection;
    private ProductoDAO productoDAO;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO merchandising (cod_producto, tipo, tamanyo) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM merchandising";
    private static final String SELECT_BY_TIPO_QUERY = "SELECT * FROM merchandising WHERE tipo = ?";
    private static final String UPDATE_QUERY = "UPDATE merchandising SET tipo = ?, tamanyo = ? WHERE cod_producto = ?";
    private static final String DELETE_QUERY = "DELETE FROM merchandising WHERE cod_producto = ?";
    private static final String TOTAL_MERCH_QUERY = "SELECT COUNT(*) FROM merchandising";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private MerchandisingDAO() {
        this.connection = DBConnection.getConnection();
        productoDAO = ProductoDAO.getInstance();
    }

    /**
     * Método estático para obtener la única instancia de MerchandisingDAO.
     *
     * @return instancia única de MerchandisingDAO.
     */
    public static synchronized MerchandisingDAO getInstance() {
        if (instance == null) {
            instance = new MerchandisingDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo merchandising en la base de datos.
     *
     * @param merchandising Objeto Merchandising a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertMerchandising(Merchandising merchandising) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, merchandising.getCod_producto());
            statement.setString(2, merchandising.getTipo());
            statement.setDouble(3, merchandising.getTamanyo());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los merchandising almacenados en la base de datos.
     *
     * @return Lista de objetos Merchandising.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Merchandising> getAllMerchandising() throws SQLException {
        List<Merchandising> merchandisings = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                merchandisings.add(resultSetToMerchandising(resultSet));
            }
        }
        return merchandisings;
    }

    /**
     * Obtiene un merchandising a partir de su tipo.
     *
     * @param tipo Tipo de merchandising.
     * @return Objeto Merchandising si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Merchandising getMerchandisingByTipo(String tipo) throws SQLException {
        Merchandising merchandising = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_TIPO_QUERY)) {
            statement.setString(1, tipo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                merchandising = resultSetToMerchandising(resultSet);
            }
        }
        return merchandising;
    }

    /**
     * Actualiza los datos de un merchandising en la base de datos.
     *
     * @param merchandising Objeto Merchandising con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateMerchandising(Merchandising merchandising) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, merchandising.getTipo());
            statement.setDouble(2, merchandising.getTamanyo());
            statement.setInt(3, merchandising.getCod_producto());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un merchandising de la base de datos por su tipo.
     *
     * @param tipo Tipo del merchandising a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteMerchandisingByTipo(String tipo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, tipo);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Merchandising.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Merchandising con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Merchandising resultSetToMerchandising(ResultSet resultSet) throws SQLException {
        Producto producto = productoDAO.getProductoByCod(resultSet.getInt("cod_producto"));

        return new Merchandising(
                producto.getCod_producto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getUnidades(),
                resultSet.getString("tipo"),
                resultSet.getDouble("tamanyo")
        );
    }

    /**
     * Obtiene el total de merchandising almacenados en la base de datos.
     *
     * @return Número total de merchandising.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalMerchandising() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_MERCH_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
