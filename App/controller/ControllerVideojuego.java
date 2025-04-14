package App.controller;

import App.db.VideojuegoDAO;
import App.db.ProductoDAO;
import App.model.Videojuego;
import App.view.VistaVideojuego;

import java.sql.SQLException;
import java.util.List;

public class ControllerVideojuego {
    private VideojuegoDAO videojuegoDAO;
    private VistaVideojuego vistaVideojuego;
    private ProductoDAO productoDAO;

    /**
     * Constructor del controlador de videojuegos.
     * Inicializa la vista y obtiene las instancias de los DAOs.
     */
    public ControllerVideojuego() {
        videojuegoDAO = VideojuegoDAO.getInstance();
        vistaVideojuego = new VistaVideojuego();
        productoDAO = ProductoDAO.getInstance();
    }

    /**
     * Muestra todos los videojuegos almacenados en la base de datos.
     */
    public void mostrarTodosLosVideojuegos() {
        try {
            List<Videojuego> videojuegos = videojuegoDAO.getAllVideojuegos();
            vistaVideojuego.mostrarVideojuegos(videojuegos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un videojuego por su código ingresado desde la vista.
     */
    public void mostrarVideojuegoPorCodigo() {
        try {
            int cod = vistaVideojuego.obtenerCodProducto();
            Videojuego videojuego = videojuegoDAO.getVideojuegoByCod(cod);
            vistaVideojuego.mostrarVideojuego(videojuego);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo videojuego con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearVideojuego() {
        try {
            Videojuego videojuego = vistaVideojuego.crearVideojuego();
            productoDAO.insertProducto(videojuego); // Insertar primero en producto
            videojuegoDAO.insertVideojuego(videojuego); // Luego en videojuego
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un videojuego existente con los datos proporcionados desde la vista.
     */
    public void actualizarVideojuego() {
        try {
            Videojuego videojuego = vistaVideojuego.obtenerDatosActualizados();
            productoDAO.updateProducto(videojuego); // Actualizar en producto
            videojuegoDAO.updateVideojuego(videojuego); // Actualizar en videojuego
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un videojuego de la base de datos usando el código ingresado desde la vista.
     */
    public void eliminarVideojuego() {
        try {
            int cod = vistaVideojuego.obtenerCodProductoAEliminar();
            videojuegoDAO.deleteVideojuegoByCod(cod); // Eliminar de videojuego
            productoDAO.deleteProductoByCod(cod); // Eliminar de producto
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

