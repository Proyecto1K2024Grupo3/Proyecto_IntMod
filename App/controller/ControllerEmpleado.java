package App.controller;

import App.db.EmpleadoDAO;
import App.model.Empleado;
import App.view.VistaEmpleado;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con empleados.
 * Conecta la vista (VistaEmpleado) con el modelo (EmpleadoDAO).
 *
 * @author Emilio, Pablo, Sergio.
 */
public class ControllerEmpleado {
    private EmpleadoDAO empleadoDAO;
    private VistaEmpleado vistaEmpleado;

    /**
     * Constructor del controlador de empleados.
     * Inicializa la vista y obtiene la instancia del DAO de empleados.
     */
    public ControllerEmpleado() {
        // Crear conexión a la base de datos
        empleadoDAO = EmpleadoDAO.getInstance();
        vistaEmpleado = new VistaEmpleado();
    }

    /**
     * Muestra todos los empleados almacenados en la base de datos.
     */
    public void mostrarTodosLosEmpleados() {
        try {
            List<Empleado> empleados = empleadoDAO.getAllEmpleados();
            vistaEmpleado.mostrarEmpleados(empleados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un empleado por su DNI ingresado desde la vista.
     */
    public void mostrarEmpleadoDNI() {
        try {
            String dni = vistaEmpleado.obtenerDni();
            Empleado empleado = empleadoDAO.getEmpleadoByDni(dni);
            vistaEmpleado.mostrarEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo empleado con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearEmpleado() {
        try {
            Empleado empleado = vistaEmpleado.crearEmpleado();
            empleadoDAO.insertEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarEmpleado() {
        try {
            Empleado empleado = vistaEmpleado.obtenerDatosActualizados();
            empleadoDAO.updateEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos usando el DNI ingresado desde la vista.
     */
    public void eliminarEmpleado() {
        try {
            String dni = vistaEmpleado.obtenerDniAEliminar();
            empleadoDAO.deleteEmpleadoByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}
