package App.controller;

import App.db.SalaDAO;
import App.model.Sala;
import App.view.VistaSala;

import java.sql.SQLException;
import java.util.List;

public class ControllerSala {
    private SalaDAO salaDAO;
    private VistaSala vistaSala;

    public ControllerSala() {
        // Crear conexión a la base de datos

        salaDAO = SalaDAO.getInstance();
        vistaSala = new VistaSala();
    }

    public void mostrarTodasLasSalas() {
        try {
            List<Sala> salas = salaDAO.getAllSalas();
            vistaSala.mostrarSalas(salas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarSalaPorNSala() {
        try {
            int n_sala = vistaSala.obtenerNSala();
            Sala sala = salaDAO.getSalaByNSala(n_sala);
            vistaSala.mostrarSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearSala() {
        try {
            Sala sala = vistaSala.crearSala();
            salaDAO.insertSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSala() {
        try {
            Sala sala = vistaSala.obtenerDatosActualizados();
            salaDAO.UpdateSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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