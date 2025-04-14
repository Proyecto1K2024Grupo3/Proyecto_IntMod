package App.controller;

import App.db.MerchandisingDAO;
import App.model.Merchandising;
import App.view.VistaMerchandising;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con merchandising.
 * Conecta la vista (VistaMerchandising) con el modelo (MerchandisingDAO).
 * Permite realizar operaciones de consulta, creación, actualización y eliminación
 * sobre merchandising.
 *
 * @author Emilio, Pablo, Sergio
 */
public class ControllerMerchandising {
    private MerchandisingDAO merchandisingDAO;
    private VistaMerchandising vistaMerchandising;

    /**
     * Constructor del controlador de merchandising.
     * Inicializa la vista y obtiene la instancia del DAO de merchandising.
     */
    public ControllerMerchandising() {
        merchandisingDAO = MerchandisingDAO.getInstance();
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
     * Busca y muestra un merchandising por su tipo.
     *
     * @param tipo Tipo de merchandising a buscar.
     */
    public void mostrarMerchandisingByTipo(String tipo) {
        try {
            Merchandising merchandising = merchandisingDAO.getMerchandisingByTipo(tipo);
            vistaMerchandising.mostrarMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo merchandising y lo inserta en la base de datos.
     *
     * @param merchandising Objeto Merchandising que contiene los datos del nuevo merchandising.
     */
    public void crearMerchandising(Merchandising merchandising) {
        try {
            merchandisingDAO.insertMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un merchandising existente con los datos proporcionados.
     *
     * @param merchandising Objeto Merchandising con los datos actualizados.
     */
    public void actualizarMerchandising(Merchandising merchandising) {
        try {
            merchandisingDAO.updateMerchandising(merchandising);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un merchandising de la base de datos usando el tipo ingresado desde la vista.
     *
     * @param tipo Tipo del merchandising que se desea eliminar.
     */
    public void eliminarMerchandising(String tipo) {
        try {
            merchandisingDAO.deleteMerchandisingByTipo(tipo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
