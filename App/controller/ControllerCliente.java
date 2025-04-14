package App.controller;

import App.db.ClienteDAO;
import App.model.Cliente;
import App.view.VistaCliente;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con clientes.
 * Conecta la vista (VistaCliente) con el modelo (ClienteDAO).
 * Permite realizar operaciones de consulta, creación, actualización y eliminación
 * sobre clientes, accediendo a la base de datos mediante ClienteDAO.
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
     * Busca y muestra un cliente por su DNI.
     *
     * @param dni DNI del cliente que se desea buscar.
     */
    public void mostrarClienteDNI(String dni) {
        try {
            Cliente cliente = clienteDAO.getClienteByDni(dni);
            vistaCliente.mostrarCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo cliente y lo inserta en la base de datos.
     *
     * @param cliente Objeto Cliente que contiene los datos del nuevo cliente.
     */
    public void crearCliente(Cliente cliente) {
        try {
            clienteDAO.insertCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un cliente existente.
     *
     * @param cliente Objeto Cliente que contiene los datos actualizados.
     */
    public void actualizarCliente(Cliente cliente) {
        try {
            clienteDAO.updateCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos usando su DNI.
     *
     * @param dni DNI del cliente que se desea eliminar.
     */
    public void eliminarCliente(String dni) {
        try {
            clienteDAO.deleteClienteByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
