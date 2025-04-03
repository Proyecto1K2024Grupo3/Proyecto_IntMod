package App.controller;

import App.db.ClienteDAO;
import App.db.EmpleadoDAO;
import App.model.Cliente;
import App.model.Empleado;
import App.view.VistaCliente;
import App.view.VistaEmpleado;

import java.sql.SQLException;
import java.util.List;


public class ControllerCliente {
    private ClienteDAO clienteDAO;
    private VistaCliente vistaCliente;

    public ControllerCliente() {
        // Crear conexión a la base de datos

        clienteDAO = ClienteDAO.getInstance();
        vistaCliente = new VistaCliente();
    }

    public void mostrarTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            vistaCliente.mostrarClientes(clientes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void mostrarClienteDNI() {
        try {
            String dni = vistaCliente.obtenerDni();
            Cliente cliente = clienteDAO.getClienteByDni(dni);
            vistaCliente.mostrarCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearCliente() {
        try {
            Cliente cliente= vistaCliente.crearCliente();
            clienteDAO.insertCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente() {
        try {
            Cliente cliente = vistaCliente.obtenerDatosActualizados();
            clienteDAO.updateCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente() {
        try {
            String dni= vistaCliente.obtenerDniAEliminar();
            clienteDAO.deleteClienteByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}
