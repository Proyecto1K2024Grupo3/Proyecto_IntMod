package App.controller;

import App.db.SalaDAO;
import App.model.Sala;
import App.view.VistaSala;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con salas.
 * Conecta la vista (VistaSala) con el modelo (SalaDAO).
 *
 * @author Emilio, Pablo, Sergio
 */
public class ControllerSala {
    private SalaDAO salaDAO;
    private VistaSala vistaSala;

    /**
     * Constructor del controlador de salas.
     * Inicializa la vista y obtiene la instancia del DAO de salas.
     */
    public ControllerSala() {
        // Crear conexión a la base de datos
        salaDAO = SalaDAO.getInstance();
        vistaSala = new VistaSala();
    }

    /**
     * Muestra todas las salas almacenadas en la base de datos.
     */
    public void mostrarTodasLasSalas() {
        try {
            List<Sala> salas = salaDAO.getAllSalas();
            vistaSala.mostrarSalas(salas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra una sala por su número (n_sala), ingresado desde la vista.
     */
    public void mostrarSalaPorNSala() {
        try {
            int n_sala = vistaSala.obtenerNSala();
            Sala sala = salaDAO.getSalaByNSala(n_sala);
            vistaSala.mostrarSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea una nueva sala con los datos ingresados desde la vista
     * y la inserta en la base de datos.
     */
    public void crearSala() {
        try {
            Sala sala = vistaSala.crearSala();
            salaDAO.insertSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de una sala existente con la información
     * proporcionada desde la vista.
     */
    public void actualizarSala() {
        try {
            Sala sala = vistaSala.obtenerDatosActualizados();
            salaDAO.UpdateSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una sala de la base de datos usando su número (n_sala)
     * ingresado desde la vista.
     */
    public void eliminarSala() {
        try {
            int n_sala = vistaSala.obtenerNSalaAEliminar();
            salaDAO.deleteSalaByNSala(n_sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}
