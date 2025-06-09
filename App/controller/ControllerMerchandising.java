package App.controller;

import App.db.MerchandisingDAO;
import App.db.ProductoDAO;
import App.model.Merchandising;
import App.view.VistaMerchandising;

import java.sql.SQLException;
import java.util.List;

public class ControllerMerchandising {
    private MerchandisingDAO merchandisingDAO;
    private ProductoDAO productoDAO;
    private VistaMerchandising vistaMerchandising;

    /**
     * Constructor del controlador de merchandising.
     * Inicializa la vista y obtiene las instancias de los DAOs.
     */
    public ControllerMerchandising() {
        merchandisingDAO = MerchandisingDAO.getInstance();
        productoDAO = ProductoDAO.getInstance();
        vistaMerchandising = new VistaMerchandising();
    }

    /**
     * Muestra todos los merchandising almacenados en la base de datos.
     */
    public void mostrarTodosLosMerchandising() {
        try {
            List<Merchandising> merchandisings = merchandisingDAO.getAllMerchandising();
            vistaMerchandising.mostrarMerchandisings(merchandisings);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un merchandising por su tipo ingresado desde la vista.
     */
    public void mostrarMerchandisingByTipo() {
        try {
            String tipo = vistaMerchandising.obtenerTipo();
            Merchandising merchandising = merchandisingDAO.getMerchandisingByTipo(tipo);
            vistaMerchandising.mostrarMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo merchandising con los datos ingresados desde la vista
     * y lo inserta en la base de datos (producto + merchandising).
     */
    public void crearMerchandising() {
        try {
            Merchandising merchandising = vistaMerchandising.crearMerchandising();
            productoDAO.insertProducto(merchandising); // Insertar primero en producto
            merchandisingDAO.insertMerchandising(merchandising); // Luego en merchandising
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un merchandising existente con los datos
     * proporcionados desde la vista (producto + merchandising).
     */
    public void actualizarMerchandising() {
        try {
            Merchandising merchandising = vistaMerchandising.obtenerDatosActualizados();
            productoDAO.updateProducto(merchandising); // Actualizar en producto
            merchandisingDAO.updateMerchandising(merchandising); // Actualizar en merchandising
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un merchandising de la base de datos usando el código ingresado desde la vista.
     */
    public void eliminarMerchandising() {
        try {
            int cod = vistaMerchandising.obtenerCodAEliminar();
            merchandisingDAO.deleteMerchandisingByCod(cod); // Eliminar de merchandising
            productoDAO.deleteProductoByCod(cod); // Eliminar de producto
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
