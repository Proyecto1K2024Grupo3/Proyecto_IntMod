package App.db;

import App.model.LineaVenta;
import App.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase LineaVentaDAO que gestiona el acceso a la base de datos para el objeto LineaVenta.
 * Implementa el patrón Singleton para asegurar una única instancia.
 *
 * @author Emilio, Pablo, Sergio
 */

public class LineaVentaDAO {

    private static LineaVentaDAO instance;
    // Conexión a la base de datos
    private Connection connection;
    private ProductoDAO productoDAO;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO linea_venta (cod_producto, cantidad, total) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM linea_venta";
    private static final String SELECT_BY_COD_PRODUCTO_QUERY = "SELECT * FROM linea_venta WHERE cod_producto = ?";
    private static final String UPDATE_QUERY = "UPDATE linea_venta SET cantidad = ?, total = ? WHERE cod_producto = ?";
    private static final String DELETE_QUERY = "DELETE FROM linea_venta WHERE cod_producto = ?";
    private static final String TOTAL_LINEASVENTA_QUERY = "SELECT COUNT(*) FROM linea_venta";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     *
     * @author Emilio, Pablo, Sergio.
     */
    private LineaVentaDAO() {
        this.productoDAO = ProductoDAO.getInstance();
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de LineaVentaDAO.
     *
     * @return instancia única de LineaVentaDAO.
     */
    public static synchronized LineaVentaDAO getInstance() {
        if (instance == null) {
            instance = new LineaVentaDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva LineaVenta en la base de datos.
     *
     * @param lineaVenta LineaVenta a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertLineaVenta(LineaVenta lineaVenta) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, lineaVenta.getProducto().getCod_producto());
            statement.setInt(2, lineaVenta.getCantidad());
            statement.setDouble(3, lineaVenta.getTotal());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las LineasVenta almacenadas en la base de datos.
     *
     * @return Lista de objetos LineaVenta.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<LineaVenta> getAllLineasVenta() throws SQLException {
        List<LineaVenta> lineas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lineas.add(resultSetToLineaVenta(resultSet));
            }
        }
        return lineas;
    }

    /**
     * Obtiene una LineaVenta a partir de su código de producto.
     *
     * @param cod_producto Código del producto de la LineaVenta.
     * @return Objeto LineaVenta si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public LineaVenta getLineaByCodProducto(int cod_producto) throws SQLException {
        LineaVenta lineaVenta = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_COD_PRODUCTO_QUERY)) {
            statement.setInt(1, cod_producto);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lineaVenta = resultSetToLineaVenta(resultSet);
            }
        }
        return lineaVenta;
    }

    /**
     * Actualiza los datos de una LineaVenta en la base de datos.
     *
     * @param lineaVenta Objeto LineaVenta con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateLineaVenta(LineaVenta lineaVenta) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, lineaVenta.getCantidad());
            statement.setDouble(2, lineaVenta.getTotal());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una LineaVenta de la base de datos por su código de producto.
     *
     * @param cod_producto Código del producto de la LineaVenta a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteLineaVentaByCodProducto(int cod_producto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, cod_producto);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto LineaVenta.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto LineaVenta con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private LineaVenta resultSetToLineaVenta(ResultSet resultSet) throws SQLException {
        Producto producto = (Producto) resultSet.getObject("cod_producto");

        return new LineaVenta(
                producto,
                resultSet.getInt("cantidad"),
                resultSet.getDouble("total"));
    }

    /**
     * Obtiene el total de LineasVenta almacenadas en la base de datos.
     *
     * @return Número total de LineasVenta.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalLineaVenta() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_LINEASVENTA_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
