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
     *
     * @param nUsuario Nombre de usuario del colaborador que se desea buscar.
     */
    public void mostrarColaboradorPorUsuario(String nUsuario) {
        try {
            Colaborador colaborador = colaboradorDAO.obtenerColaboradorPorUsuario(nUsuario);
            vistaColaborador.mostrarColaborador(colaborador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo colaborador y lo inserta en la base de datos.
     *
     * @param colaborador Objeto Colaborador que contiene los datos del nuevo colaborador.
     */
    public void crearColaborador(Colaborador colaborador) {
        try {
            colaboradorDAO.insertarColaborador(colaborador);
            vistaColaborador.mostrarMensaje("Colaborador creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un colaborador existente.
     *
     * @param colaborador Objeto Colaborador que contiene los datos actualizados.
     */
    public void actualizarColaborador(Colaborador colaborador) {
        try {
            colaboradorDAO.actualizarColaborador(colaborador);
            vistaColaborador.mostrarMensaje("Colaborador actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un colaborador de la base de datos usando su nombre de usuario.
     *
     * @param nUsuario Nombre de usuario del colaborador que se desea eliminar.
     */
    public void eliminarColaborador(String nUsuario) {
        try {
            colaboradorDAO.eliminarColaboradorPorUsuario(nUsuario);
            vistaColaborador.mostrarMensaje("Colaborador eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
