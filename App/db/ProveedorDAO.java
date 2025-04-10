package App.db;

import App.model.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private static ProveedorDAO instance;
    private Connection connection;

    private static final String SELECT_NIF_PROVEEDOR_QUERY = "SELECT * FROM proveedor WHERE nif = ?";
    private static final String INSERT_PROVEEDOR_QUERY = "INSERT INTO proveedor (nif, nombre, direccion) VALUES (?, ?, ?)";
    private static final String TOTAL_PROVEEDORES_QUERY = "SELECT COUNT(*) FROM proveedor";
    private static final String UPDATE_PROVEEDOR_QUERY = "UPDATE proveedor SET nombre = ?, direccion = ? WHERE nif = ?";
    private static final String DELETE_PROVEEDOR_QUERY = "DELETE FROM proveedor WHERE nif = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM proveedor";


    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private ProveedorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estático para obtener la única instancia de ProveedorDAO.
     * @return instancia única de ProveedorDAO.
     */
    public static synchronized ProveedorDAO getInstance() {
        if (instance == null) {
            instance = new ProveedorDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo proveedor en la base de datos.
     * @param proveedor Objeto proveedor a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertProvedor(Proveedor proveedor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PROVEEDOR_QUERY)) {
            statement.setString(1, proveedor.getNif());
            statement.setString(2, proveedor.getNombre());
            statement.setString(3, proveedor.getDireccion());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los proveedores almacenados en la base de datos.
     * @return Lista de objetos proveedores.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Proveedor> getAllProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                proveedores.add(resultSetToProveedor(resultSet));
            }
        }
        return proveedores;
    }

    /**
     * Obtiene un proveedor a partir de su NIF.
     * @param nif Identificador único del proveedor.
     * @return Objeto Proveedor si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Proveedor getProveedorByNif(String nif) throws SQLException {
        Proveedor proveedor = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_NIF_PROVEEDOR_QUERY)) {
            statement.setString(1, nif);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                proveedor = resultSetToProveedor(resultSet);
            }
        }
        return proveedor;
    }

    /**
     * Actualiza los datos de un proveedor en la base de datos.
     * @param proveedor Objeto proveedor con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateProveedor(Proveedor proveedor) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PROVEEDOR_QUERY)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getDireccion());
            statement.setString(3, proveedor.getNif());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un proveedor de la base de datos por su NIF.
     * @param nif Identificador único del proveedor a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteProvedorByNif(String nif) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PROVEEDOR_QUERY)) {
            statement.setString(1, nif);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Proveedor.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Proveedor con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Proveedor resultSetToProveedor(ResultSet resultSet) throws SQLException {
        return new Proveedor(
                resultSet.getString("nif"),
                resultSet.getString("nombre"),
                resultSet.getString("direccion"));
    }

    /**
     * Obtiene el total de proveedores almacenados en la base de datos.
     * @return Número total de proveedores.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalProveedores() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PROVEEDORES_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
