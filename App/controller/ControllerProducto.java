package App.controller;

import App.db.EmpleadoDAO;
import App.db.ProductoDAO;
import App.model.Empleado;
import App.model.Producto;
import App.view.VistaEmpleado;
import App.view.VistaProducto;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con empleados.
 * Conecta la vista (VistaEmpleado) con el modelo (EmpleadoDAO).
 *
 * @author Emilio, Pablo, Sergio.
 */
public class ControllerProducto {
    private ProductoDAO productoDAO;
    private VistaProducto vistaProducto;

    /**
     * Constructor del controlador de empleados.
     * Inicializa la vista y obtiene la instancia del DAO de empleados.
     */
    public ControllerProducto() {
        // Crear conexión a la base de datos
        productoDAO = ProductoDAO.getInstance();
        vistaProducto = new VistaProducto();
    }

    /**
     * Muestra todos los empleados almacenados en la base de datos.
     */
    public void mostrarTodosLosProductos() {
        try {
            List<Producto> productos = productoDAO.getAllProductos();
            vistaProducto.mostrarProductos(productos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un empleado por su DNI ingresado desde la vista.
     */
    public void mostrarProductoCod() {
        try {
            int cod = vistaProducto.obtenerCod();
            Producto producto = productoDAO.getProductoByCod(cod);
            vistaProducto.mostrarProducto(producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo empleado con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearProducto() {
        try {
            Producto producto = vistaProducto.crearProductos();
            productoDAO.insertProducto(producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarProducto() {
        try {
            Producto producto = vistaProducto.obtenerDatosActualizados();
            productoDAO.updateProducto(producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos usando el DNI ingresado desde la vista.
     */
    public void eliminarProducto() {
        try {
            int cod = vistaProducto.obtenerCodAEliminar();
            productoDAO.deleteProductoByCod(cod);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}
