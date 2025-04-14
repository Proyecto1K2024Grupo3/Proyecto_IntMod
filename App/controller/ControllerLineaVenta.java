package App.controller;

import App.db.EmpleadoDAO;
import App.db.LineaVentaDAO;
import App.db.ProductoDAO;
import App.model.Empleado;
import App.model.LineaVenta;
import App.model.Producto;
import App.view.VistaEmpleado;
import App.view.VistaLineaVenta;
import App.view.VistaProducto;

import java.sql.SQLException;
import java.util.List;

public class ControllerLineaVenta {
    private LineaVentaDAO lineaVentaDAO;
    private ProductoDAO productoDAO;
    private VistaLineaVenta vistaLineaVenta;
    private VistaProducto vistaProducto;

    /**
     * Constructor del controlador de empleados.
     * Inicializa la vista y obtiene la instancia del DAO de empleados.
     */
    public ControllerLineaVenta() {
        // Crear conexión a la base de datos
        lineaVentaDAO = LineaVentaDAO.getInstance();
        productoDAO = ProductoDAO.getInstance();
        vistaProducto = new VistaProducto();
        vistaLineaVenta = new VistaLineaVenta();
    }

    /**
     * Muestra todos los empleados almacenados en la base de datos.
     */
    public void mostrarTodasLasLineasDeVenta() {
        try {
            List<LineaVenta> lineaVentas = lineaVentaDAO.getAllLineasVenta();
            vistaLineaVenta.mostrarLineasVentas(lineaVentas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un empleado por su DNI ingresado desde la vista.
     */
    public void mostrarLineaCodProducto() {
        try {
            int cod_producto = vistaLineaVenta.obtenerCodProducto();
            LineaVenta lineaVenta = lineaVentaDAO.getLineaByCodProducto(cod_producto);
            vistaLineaVenta.mostrarLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo empleado con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearLineaVenta() {
        try {
            int cod_producto = vistaProducto.obtenerCod();
            Producto producto = productoDAO.getProductoByCod(cod_producto);
            LineaVenta lineaVenta = vistaLineaVenta.crearLineaVenta(producto);
            lineaVentaDAO.insertLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarLineaVenta() {
        try {
            int cod_producto = vistaProducto.obtenerCod();
            Producto producto = productoDAO.getProductoByCod(cod_producto);
            LineaVenta lineaVenta = vistaLineaVenta.obtenerDatosActualizados(producto);
            lineaVentaDAO.updateLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos usando el DNI ingresado desde la vista.
     */
    public void eliminarLineaVenta() {
        try {
            int cod_producto = vistaLineaVenta.obtenerCod_ProductoAEliminar();
            lineaVentaDAO.deleteLineaVentaByCodProducto(cod_producto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
