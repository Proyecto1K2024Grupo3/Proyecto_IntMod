package App.controller;

import App.db.LineaVentaDAO;
import App.db.ProductoDAO;
import App.model.LineaVenta;
import App.model.Producto;
import App.view.VistaLineaVenta;
import App.view.VistaProducto;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las líneas de venta.
 * Conecta la vista (VistaLineaVenta) con el modelo (LineaVentaDAO).
 * Permite realizar operaciones de consulta, creación, actualización y eliminación
 * sobre las líneas de venta.
 *
 * @author Emilio, Pablo, Sergio
 */
public class ControllerLineaVenta {
    private LineaVentaDAO lineaVentaDAO;
    private ProductoDAO productoDAO;
    private VistaLineaVenta vistaLineaVenta;
    private VistaProducto vistaProducto;

    /**
     * Constructor del controlador de líneas de venta.
     * Inicializa las vistas y obtiene la instancia de los DAOs.
     */
    public ControllerLineaVenta() {
        lineaVentaDAO = LineaVentaDAO.getInstance();
        productoDAO = ProductoDAO.getInstance();
        vistaProducto = new VistaProducto();
        vistaLineaVenta = new VistaLineaVenta();
    }

    /**
     * Muestra todas las líneas de venta almacenadas en la base de datos.
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
     * Busca y muestra una línea de venta por el código del producto.
     *
     * @param codProducto Código del producto asociado a la línea de venta.
     */
    public void mostrarLineaCodProducto(int codProducto) {
        try {
            LineaVenta lineaVenta = lineaVentaDAO.getLineaByCodProducto(codProducto);
            vistaLineaVenta.mostrarLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea una nueva línea de venta y la inserta en la base de datos.
     *
     * @param producto Producto asociado a la línea de venta.
     * @param lineaVenta Objeto LineaVenta que contiene los datos de la venta.
     */
    public void crearLineaVenta(Producto producto, LineaVenta lineaVenta) {
        try {
            // Aquí asumes que la línea ya viene bien formada con ese producto.
            lineaVentaDAO.insertLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de una línea de venta existente.
     *
     * @param producto Producto asociado a la línea de venta.
     * @param lineaVenta Objeto LineaVenta con los datos actualizados.
     */
    public void actualizarLineaVenta(Producto producto, LineaVenta lineaVenta) {
        try {
            // Actualiza la línea de venta con los nuevos datos.
            lineaVentaDAO.updateLineaVenta(lineaVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una línea de venta de la base de datos usando el código del producto.
     *
     * @param codProducto Código del producto cuya línea de venta se desea eliminar.
     */
    public void eliminarLineaVenta(int codProducto) {
        try {
            lineaVentaDAO.deleteLineaVentaByCodProducto(codProducto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
