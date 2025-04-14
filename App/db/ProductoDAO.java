package App.db;

import App.model.Empleado;
import App.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ProductoDAO que gestiona el acceso a la base de datos para la entidad Producto.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class ProductoDAO {

    // Instancia única de ProductoDAO
    private static ProductoDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO producto (cod_producto, precio, unidades, nombre) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM producto";
    private static final String SELECT_BY_COD_QUERY = "SELECT * FROM producto WHERE cod_producto = ?";
    private static final String UPDATE_QUERY = "UPDATE producto SET precio = ?, unidades = ?, nombre = ? WHERE cod_producto = ?";
    private static final String DELETE_QUERY = "DELETE FROM producto WHERE cod_producto = ?";
    private static final String TOTAL_PRODUCTOS_QUERY = "SELECT COUNT(*) FROM producto";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private ProductoDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de ProductoDAO.
     *
     * @return instancia única de ProductoDAO.
     */
    public static synchronized ProductoDAO getInstance() {
        if (instance == null) {
            instance = new ProductoDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo producto en la base de datos.
     *
     * @param producto Objeto Producto a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertProducto(Producto producto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, producto.getCod_producto());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getUnidades());
            statement.setString(4, producto.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los productos almacenados en la base de datos.
     *
     * @return Lista de objetos Producto.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Producto> getAllProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                productos.add(resultSetToProducto(resultSet));
            }
        }
        return productos;
    }

    /**
     * Obtiene un producto a partir de su código.
     *
     * @param cod Código único del producto.
     * @return Objeto Producto si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Producto getProductoByCod(int cod) throws SQLException {
        Producto producto = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_COD_QUERY)) {
            statement.setInt(1, cod);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                producto = resultSetToProducto(resultSet);
            }
        }
        return producto;
    }

    /**
     * Actualiza los datos de un producto en la base de datos.
     *
     * @param producto Objeto Producto con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateProducto(Producto producto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setDouble(1, producto.getPrecio());
            statement.setInt(2, producto.getUnidades());
            statement.setString(3, producto.getNombre());
            statement.setInt(4, producto.getCod_producto());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un producto de la base de datos por su código.
     *
     * @param cod Código único del producto a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteProductoByCod(int cod) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, cod);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Producto.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Producto con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Producto resultSetToProducto(ResultSet resultSet) throws SQLException {
        return new Producto(
                resultSet.getInt("cod_producto"),
                resultSet.getInt("precio"),
                resultSet.getInt("unidades"),
                resultSet.getString("nombre"));
    }

    /**
     * Obtiene el total de productos almacenados en la base de datos.
     *
     * @return Número total de productos.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalProductos() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PRODUCTOS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
