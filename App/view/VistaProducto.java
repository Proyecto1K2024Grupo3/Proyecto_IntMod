package App.view;

import App.model.Empleado;
import App.model.Producto;

import java.util.List;
import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con productos.
 * @author Emilio, Pablo, Sergio
 */
public class VistaProducto {

    public Scanner scanner;

    /**
     * Constructor desparametrizado que inicializa el scanner de la clase.
     */
    public VistaProducto() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra una lista de productos por consola.
     *
     * @param productos Lista de objetos Producto a mostrar.
     */
    public void mostrarProductos(List<Producto> productos) {
        System.out.println("Lista de Productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    /**
     * Solicita al usuario los datos de un nuevo producto y los devuelve como objeto.
     *
     * @return Producto creado con los datos introducidos.
     */
    public Producto crearProductos() {
        System.out.println("Introduce el cod_producto:");
        int cod_producto = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el precio:");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce las unidades: ");
        int unidades = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nombre del producto:");
        String nombre = scanner.nextLine();

        return new Producto(cod_producto, precio, unidades, nombre);
    }

    /**
     * Solicita al usuario el código del producto que desea eliminar.
     *
     * @return Código del producto como entero.
     */
    public int obtenerCodAEliminar() {
        System.out.println("Introduce el codigo del producto a eliminar:");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Solicita al usuario los datos actualizados de un producto.
     *
     * @return Producto con los nuevos datos.
     */
    public Producto obtenerDatosActualizados() {
        System.out.println("Introduce el cod_producto:");
        int cod_producto = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el precio:");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce las unidades: ");
        int unidades = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nombre del producto:");
        String nombre = scanner.nextLine();

        return new Producto(cod_producto, precio, unidades, nombre);
    }

    /**
     * Muestra un mensaje en consola.
     *
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita al usuario el código de un producto.
     *
     * @return Código del producto introducido por el usuario.
     */
    public int obtenerCod() {
        System.out.println("Introduce el codigo del producto:");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Muestra los datos de un producto por consola.
     *
     * @param producto Producto a mostrar. Si es null, se indica que no existe.
     */
    public void mostrarProducto(Producto producto) {
        if(producto != null)
            System.out.println(producto);
        else
            System.out.println("El producto no existe");
    }

    // Otros métodos de la vista...
}
