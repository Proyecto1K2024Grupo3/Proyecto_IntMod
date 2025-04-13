package App.controller;

import App.db.MerchandisingDAO;
import App.model.Merchandising;
import App.view.VistaMerchandising;

import java.sql.SQLException;
import java.util.List;

public class ControllerMerchandising {
    private MerchandisingDAO merchandisingDAO;
    private VistaMerchandising vistaMerchandising;

    /**
     * Constructor del controlador de empleados.
     * Inicializa la vista y obtiene la instancia del DAO de empleados.
     */
    public ControllerMerchandising() {
        // Crear conexión a la base de datos
        merchandisingDAO = MerchandisingDAO.getInstance();
        vistaMerchandising = new VistaMerchandising();
    }

    /**
     * Muestra todos los empleados almacenados en la base de datos.
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
     * Busca y muestra un empleado por su DNI ingresado desde la vista.
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
     * Crea un nuevo empleado con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearMerchandising() {
        try {
            Merchandising merchandising = vistaMerchandising.crearMerchandising();
            merchandisingDAO.insertMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarMerchandising() {
        try {
            Merchandising merchandising = vistaMerchandising.obtenerDatosActualizados();
            merchandisingDAO.updateMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos usando el DNI ingresado desde la vista.
     */
    public void eliminarMerchandising() {
        try {
            String tipo = String.valueOf(vistaMerchandising.obtenerTipoAEliminar());
            merchandisingDAO.deleteMerchandisingByTipo(tipo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
