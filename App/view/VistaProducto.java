package App.view;

import App.model.Empleado;
import App.model.Producto;

import java.util.List;
import java.util.Scanner;

public class VistaProducto {
    public Scanner scanner;

    public VistaProducto() {
        scanner = new Scanner(System.in);
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("Lista de Productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

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

    public int obtenerCodAEliminar() {
        System.out.println("Introduce el codigo del producto a eliminar:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Producto obtenerDatosActualizados() {
        System.out.println("Introduce el cod_producto:");
        int cod_producto = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el precio:");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce las unidades: ");
        int telefono = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nombre del producto:");
        String nombre = scanner.nextLine();

        return new Producto(cod_producto, precio, telefono, nombre);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerCod() {
        System.out.println("Introduce el codigo del producto:");
        return Integer.parseInt(scanner.nextLine());
    }
    //muestra los datos de la persona
    public void mostrarProducto(Producto producto) {
        if(producto!=null)
            System.out.println(producto);
        else
            System.out.println("El producto no existe");
    }

    // Otros métodos de la vista...
}

