package App.controller;

import App.db.ProveedorDAO;
import App.model.Proveedor;
import App.view.VistaProveedor;

import java.sql.SQLException;
import java.util.List;

public class ControllerProveedores {
    private ProveedorDAO proveedorDAO;
    private VistaProveedor vistaProveedor;

    /**
     * Constructor del controlador de proveedores.
     * Inicializa la vista y obtiene la instancia del DAO de proveedores.
     */
    public ControllerProveedores() {
        // Crear conexión a la base de datos
        proveedorDAO = ProveedorDAO.getInstance();
        vistaProveedor = new VistaProveedor();
    }

    /**
     * Muestra todos los proveedores almacenados en la base de datos.
     */
    public void mostrarTodosLosProveedores() {
        try {
            List<Proveedor> proveedores = proveedorDAO.getAllProveedores();
            vistaProveedor.mostrarProveedores(proveedores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca y muestra un proveedor por su NIF ingresado desde la vista.
     */
    public void mostrarProveedorNIF() {
        try {
            String nif = vistaProveedor.obtenerNif();
            Proveedor proveedor = proveedorDAO.getProveedorByNif(nif);
            vistaProveedor.mostrarProveedor(proveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo proveedor con los datos ingresados desde la vista
     * y lo inserta en la base de datos.
     */
    public void crearProveedor() {
        try {
            Proveedor proveedor = vistaProveedor.crearProveedor();
            proveedorDAO.insertProvedor(proveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un proveedor existente con los datos
     * proporcionados desde la vista.
     */
    public void actualizarProveedor() {
        try {
            Proveedor proveedor = vistaProveedor.obtenerDatosActualizados();
            proveedorDAO.updateProveedor(proveedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un proveedor de la base de datos usando el NIF ingresado desde la vista.
     */
    public void eliminarProveedor() {
        try {
            String nif = vistaProveedor.obtenerNifAEliminar();
            proveedorDAO.deleteProvedorByNif(nif);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
