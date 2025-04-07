package App.db;

import App.model.Cliente;
import App.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static ClienteDAO instance;
    private Connection connection;

    private static final String SELECT_DNI_CLIENTE_QUERY = "SELECT * FROM CLIENTE WHERE dni = ?";
    private static final String INSERT_CLIENTE_QUERY = "INSERT INTO CLIENTE (dni, nombre) VALUES (?, ?)";
    private static final String TOTAL_CLIENTE_QUERY = "SELECT COUNT(*) FROM CLIENTE";
    private static final String UPDATE_CLIENTE_QUERY = "UPDATE CLIENTE SET nombre = ?, dni = ?";
    private static final String DELETE_CLIENTE_QUERY = "DELETE FROM CLIENTE WHERE dni = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CLIENTE";


    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estático para obtener la única instancia de ClienteDAO.
     * @return instancia única de ClienteDAO.
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     * @param cliente Objeto cliente a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CLIENTE_QUERY)) {
            statement.setString(1, cliente.getDni());
            statement.setString(2, cliente.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los clientes almacenados en la base de datos.
     * @return Lista de objetos cliente.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clientes.add(resultSetToCliente(resultSet));
            }
        }
        return clientes;
    }

    /**
     * Obtiene un cliente a partir de su DNI.
     * @param dni Identificador único del cliente.
     * @return Objeto Cliente si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Cliente getClienteByDni(String dni) throws SQLException {
        Cliente cliente = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_DNI_CLIENTE_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = resultSetToCliente(resultSet);
            }
        }
        return cliente;
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * @param cliente Objeto cliente con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTE_QUERY)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDni());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un cliente de la base de datos por su DNI.
     * @param dni Identificador único del cliente a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteClienteByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CLIENTE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Cliente.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Cliente con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getInt("cod_cliente"),
                resultSet.getString("dni"),
                resultSet.getString("nombre"));
    }

    /**
     * Obtiene el total de clientes almacenados en la base de datos.
     * @return Número total de clientes.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalClientes() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_CLIENTE_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
