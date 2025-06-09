package App.db;

import App.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PersonaDAO que gestiona el acceso a la base de datos para la entidad Persona.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class EmpleadoDAO {

    // Instancia única de PersonaDAO
    private static EmpleadoDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO empleado (dni, telefono, f_Nacimiento, nombre) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM empleado";
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM empleado WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE empleado SET telefono = ?, f_Nacimiento = ?, nombre = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM empleado WHERE dni = ?";
    private static final String TOTAL_PERSONAS_QUERY = "SELECT COUNT(*) FROM empleado";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private EmpleadoDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de PersonaDAO.
     */
    public static synchronized EmpleadoDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva persona en la base de datos.
     * @param persona Objeto Persona a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertEmpleado(Empleado empleado) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, empleado.getDni());
            statement.setString(2, empleado.getTelefono());
            statement.setString(3, empleado.getFechaNacimiento());
            statement.setString(4, empleado.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las personas almacenadas en la base de datos.
     * @return Lista de objetos Persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Empleado> getAllEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                empleados.add(resultSetToEmpleado(resultSet));
            }
        }
        return empleados;
    }

    /**
     * Obtiene una persona a partir de su DNI.
     * @param dni Identificador único de la persona.
     * @return Objeto Persona si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Empleado getEmpleadoByDni(String dni) throws SQLException {
        Empleado empleado = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = resultSetToEmpleado(resultSet);
            }
        }
        return empleado;
    }

    /**
     * Actualiza los datos de una persona en la base de datos.
     * @param persona Objeto Persona con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updateEmpleado(Empleado empleado) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, empleado.getTelefono());
            statement.setString(2, empleado.getFechaNacimiento());
            statement.setString(3, empleado.getNombre());
            statement.setString(4, empleado.getDni());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una persona de la base de datos por su DNI.
     * @param dni Identificador único de la persona a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deleteEmpleadoByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Persona.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Persona con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Empleado resultSetToEmpleado(ResultSet resultSet) throws SQLException {
        return new Empleado(
                resultSet.getString("dni"),
                resultSet.getInt("cod_empleado"),
                resultSet.getString("telefono"),
                resultSet.getString("f_Nacimiento"),
                resultSet.getString("nombre"));
    }

    /**
     * Obtiene el total de personas almacenadas en la base de datos.
     * @return Número total de personas.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalEmpleados() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PERSONAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
