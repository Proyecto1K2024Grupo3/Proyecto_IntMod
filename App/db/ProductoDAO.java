//package App.db;
//
//import App.model.Empleado;
//import App.model.Producto;
//import App.model.Proveedor;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Clase PersonaDAO que gestiona el acceso a la base de datos para la entidad Persona.
// * Implementa el patrón Singleton para asegurar una única instancia.
// */
//public class ProductoDAO {
//
//    // Instancia única de PersonaDAO
//    private static ProductoDAO instance;
//    // Conexión a la base de datos
//    private Connection connection;
//
//    // Consultas SQL predefinidas para operaciones CRUD
//    private static final String INSERT_QUERY = "INSERT INTO PRODUCTO (nombre, unidades, precio, nif_proveedor, empleado_registro) VALUES (?, ?, ?, ?, ?)";
//    private static final String SELECT_ALL_QUERY = "SELECT * FROM PRODUCTO";
//    private static final String SELECT_BY_COD_PRODUCT_QUERY = "SELECT * FROM PRODUCTO WHERE cod_producto = ?";
//    private static final String UPDATE_QUERY = "UPDATE PRODUCTO SET precio = ?, unidades = ?, nombre = ? WHERE cod_producto = ?";
//    private static final String DELETE_QUERY = "DELETE FROM PRODUCTO WHERE cod_producto = ?";
//    private static final String TOTAL_PRODUCTOS_QUERY = "SELECT COUNT(*) FROM PRODUCTO";
//
//    /**
//     * Constructor privado para evitar instanciación externa.
//     * Obtiene la conexión a la base de datos desde DBConnection.
//     */
//    private ProductoDAO() {
//        this.connection = DBConnection.getConnection();
//    }
//
//    /**
//     * Método estático para obtener la única instancia de ProductoDAO.
//     * @return instancia única de ProductoDAO.
//     */
//    public static synchronized ProductoDAO getInstance() {
//        if (instance == null) {
//            instance = new ProductoDAO();
//        }
//        return instance;
//    }
//
//    /**
//     * Inserta un nuevo producto en la base de datos.
//     * @param producto objerto producto a insertar.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public void insertProducto(Producto producto) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
//            statement.setString(1, producto.getNombre());
//            statement.setString(2, String.valueOf(producto.getPrecio()));
//            statement.setString(3, String.valueOf(producto.getUnidades()));
//            statement.setString(4, producto.getProvedor().getNif());
//            statement.setString(5, producto.getEmpleadoRegistro().getDni());
//            statement.executeUpdate();
//        }
//    }
//
//    /**
//     * Obtiene todas las personas almacenadas en la base de datos.
//     * @return Lista de objetos Producto.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public List<Producto> getAllProductos() throws SQLException {
//        List<Producto> productos = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                productos.add(resultSet(resultSet));
//            }
//        }
//        return productos;
//    }
//
//    /**
//     * Obtiene una persona a partir de su DNI.
//     * @param dni Identificador único de la persona.
//     * @return Objeto Persona si se encuentra, null si no.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public Empleado getEmpleadoByDni(String dni) throws SQLException {
//        Empleado empleado = null;
//        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_COD_PRODUCT_QUERY)) {
//            statement.setString(1, dni);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                empleado = resultSetToEmpleado(resultSet);
//            }
//        }
//        return empleado;
//    }
//
//    /**
//     * Actualiza los datos de una persona en la base de datos.
//     * @param persona Objeto Persona con los datos actualizados.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public void updateEmpleado(Empleado empleado) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
//            statement.setString(1, empleado.getTelefono());
//            statement.setString(2, empleado.getFechaNacimiento());
//            statement.setString(3, empleado.getNombre());
//            statement.setString(4, empleado.getDni());
//            statement.executeUpdate();
//        }
//    }
//
//    /**
//     * Elimina una persona de la base de datos por su DNI.
//     * @param dni Identificador único de la persona a eliminar.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public void deleteEmpleadoByDni(String dni) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
//            statement.setString(1, dni);
//            statement.executeUpdate();
//        }
//    }
//
//    /**
//     * Convierte un ResultSet en un objeto Producto.
//     * @param resultSet Resultado de la consulta SQL.
//     * @return Objeto Producto con los datos del ResultSet.
//     * @throws SQLException Si ocurre un error en la conversión.
//     */
//    private Producto resultSetToProducto(ResultSet resultSet) throws SQLException {
//        return new Producto(
//                resultSet.getString("nombre"),
//                resultSet.getInt("unidades"),
//                resultSet.getInt("precio"),
//                resultSet.,
//                resultSet.;
//    }
//
//    /**
//     * Obtiene el total de personas almacenadas en la base de datos.
//     * @return Número total de personas.
//     * @throws SQLException Si ocurre un error en la base de datos.
//     */
//    public int totalEmpleados() throws SQLException {
//        int total = 0;
//        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PRODUCTOS_QUERY)) {
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                total = resultSet.getInt(1);
//            }
//        }
//        return total;
//    }
//}