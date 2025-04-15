package App.controller;

import App.db.ColaboradorDAO;
import App.model.Colaborador;
import App.view.VistaColaborador;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con colaboradores.
 * Conecta la vista (VistaColaborador) con el modelo (ColaboradorDAO).
 * Permite realizar operaciones de consulta, creación, actualización y eliminación
 * sobre colaboradores.
 *
 * @author Emilio, Pablo, Sergio
 */
public class ControllerColaborador {
    private ColaboradorDAO colaboradorDAO;
    private VistaColaborador vistaColaborador;

    /**
     * Constructor del controlador de colaboradores.
     * Inicializa la vista y obtiene la instancia del DAO de colaboradores.
     */
    public ControllerColaborador() {
        colaboradorDAO = ColaboradorDAO.getInstance();
        vistaColaborador = new VistaColaborador();
    }

    /**
     * Muestra todos los colaboradores almacenados en la base de datos.
     */
    public void mostrarTodosLosColaboradores() {
        try {
            List<Colaborador> colaboradores = colaboradorDAO.obtenerTodosColaboradores();
            vistaColaborador.mostrarColaboradores(colaboradores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un colaborador por su nombre de usuario.
     */
    public void mostrarColaboradorPorUsuario() {
        try {
            String nUsuario = vistaColaborador.obtenerUsuario();
            Colaborador colaborador = colaboradorDAO.obtenerColaboradorPorUsuario(nUsuario);
            vistaColaborador.mostrarColaborador(colaborador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo colaborador y lo inserta en la base de datos.
     */
    public void crearColaborador() {
        try {
            Colaborador colaborador = vistaColaborador.crearColaborador();
            colaboradorDAO.insertarColaborador(colaborador);
            vistaColaborador.mostrarMensaje("Colaborador creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un colaborador existente.
     */
    public void actualizarColaborador() {
        try {
            Colaborador colaborador = vistaColaborador.obtenerDatosActualizados();
            colaboradorDAO.actualizarColaborador(colaborador);
            vistaColaborador.mostrarMensaje("Colaborador actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un colaborador de la base de datos usando su nombre de usuario.
     */
    public void eliminarColaborador() {
        try {
            String nUsuario = vistaColaborador.obtenerUsuarioAEliminar();
            colaboradorDAO.eliminarColaboradorPorUsuario(nUsuario);
            vistaColaborador.mostrarMensaje("Colaborador eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
