package App.controller;

import App.db.EmpleadoDAO;
import App.model.Empleado;
import App.view.VistaEmpleado;

import java.sql.SQLException;
import java.util.List;

public class ControllerEmpleado {
    private EmpleadoDAO empleadoDAO;
    private VistaEmpleado vistaEmpleado;

    public ControllerEmpleado() {
        // Crear conexión a la base de datos

        empleadoDAO = EmpleadoDAO.getInstance();
        vistaEmpleado = new VistaEmpleado();
    }

    public void mostrarTodosLosEmpleados() {
        try {
            List<Empleado> empleados = empleadoDAO.getAllEmpleados();
            vistaEmpleado.mostrarEmpleados(empleados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void mostrarEmpleadoDNI() {
        try {
            String dni = vistaEmpleado.obtenerDni();
            Empleado empleado = empleadoDAO.getEmpleadoByDni(dni);
            vistaEmpleado.mostrarEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearEmpleado() {
        try {
            Empleado empleado= vistaEmpleado.crearEmpleado();
            empleadoDAO.insertEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmpleado() {
        try {
            Empleado empleado= vistaEmpleado.obtenerDatosActualizados();
            empleadoDAO.updateEmpleado(empleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado() {
        try {
            String dni= vistaEmpleado.obtenerDniAEliminar();
            empleadoDAO.deleteEmpleadoByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}