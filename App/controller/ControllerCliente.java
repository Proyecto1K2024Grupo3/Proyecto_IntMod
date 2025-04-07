package App.controller;

import App.db.ClienteDAO;
import App.model.Cliente;
import App.view.VistaCliente;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con clientes.
 * Conecta la vista (VistaCliente) con el modelo (ClienteDAO).
 *
 * @author Emilio, Pablo, Sergio
 */
public class ControllerCliente {
    private ClienteDAO clienteDAO;
    private VistaCliente vistaCliente;

    /**
     * Constructor del controlador de clientes.
     * Inicializa la vista y obtiene la instancia del DAO de clientes.
     */
    public ControllerCliente() {
        // Crear conexión a la base de datos
        clienteDAO = ClienteDAO.getInstance();
        vistaCliente = new VistaCliente();
    }

    /**
     * Muestra todos los clientes almacenados en la base de datos.
     */
    public void mostrarTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            vistaCliente.mostrarClientes(clientes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un cliente por su DNI ingresado desde la vista.
     */
    public void mostrarClienteDNI() {
        try {
            String dni = vistaCliente.obtenerDni();
            Cliente cliente = clienteDAO.getClienteByDni(dni);
            vistaCliente.mostrarCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo cliente con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearCliente() {
        try {
            Cliente cliente = vistaCliente.crearCliente();
            clienteDAO.insertCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un cliente existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarCliente() {
        try {
            Cliente cliente = vistaCliente.obtenerDatosActualizados();
            clienteDAO.updateCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos usando el DNI ingresado desde la vista.
     */
    public void eliminarCliente() {
        try {
            String dni = vistaCliente.obtenerDniAEliminar();
            clienteDAO.deleteClienteByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
