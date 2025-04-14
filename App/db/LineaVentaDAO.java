package App.db;

import App.model.Empleado;
import App.model.LineaVenta;
import App.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
     */
    private LineaVentaDAO() {
        this.productoDAO = ProductoDAO.getInstance();
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de PersonaDAO.
     */
    public static synchronized LineaVentaDAO getInstance() {
        if (instance == null) {
            instance = new LineaVentaDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva lineaVenta en la base de datos.
     * @param lineaVenta lineaVenta a insertar
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
     * Obtiene todas las personas almacenadas en la base de datos.
     *
     * @return Lista de objetos Persona.
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
     * Obtiene una persona a partir de su DNI.
     * @param dni Identificador único de la persona.
     * @return Objeto Persona si se encuentra, null si no.
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
     * Actualiza los datos de una persona en la base de datos.
     * @param persona Objeto Persona con los datos actualizados.
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
     * Elimina una persona de la base de datos por su DNI.
     * @param dni Identificador único de la persona a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteLineaVentaByCodProducto(int cod_producto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, cod_producto);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Persona.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Persona con los datos del ResultSet.
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
     * Obtiene el total de personas almacenadas en la base de datos.
     * @return Número total de personas.
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
