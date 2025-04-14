package App.view;

import App.model.Producto;
import App.model.Videojuego;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class VistaVideojuego {
    private Scanner scanner;
    private VistaProducto vistaProducto;

    public VistaVideojuego() {
        this.vistaProducto = new VistaProducto();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarVideojuegos(List<Videojuego> videojuegos) {
        System.out.println("Lista de videojuegos:");
        for (Videojuego v : videojuegos) {
            System.out.println(v);
        }
    }

    public Videojuego crearVideojuego() {
        Producto producto = vistaProducto.crearProductos();
        System.out.println("Fecha de lanzamiento (formato: YYYY-MM-DD): ");
        String fechaLanzamiento = leerFecha();

        return new Videojuego(producto.getCod_producto(), producto.getPrecio(), producto.getUnidades(), producto.getNombre(), fechaLanzamiento);
    }

    public int obtenerCodProductoAEliminar() {
        System.out.println("Introduce el código del videojuego a eliminar:");
        return Integer.parseInt(scanner.nextLine());
    }

    public Videojuego obtenerDatosActualizados() {
        Producto producto = vistaProducto.obtenerDatosActualizados();
        System.out.println("Nueva fecha de lanzamiento (formato: YYYY-MM-DD): ");
        String nuevaFecha = leerFecha();

        return new Videojuego(producto.getCod_producto(), producto.getPrecio(), producto.getUnidades(), producto.getNombre(), nuevaFecha);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerCodProducto() {
        System.out.println("Introduce el código del videojuego:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarVideojuego(Videojuego videojuego) {
        if (videojuego != null)
            System.out.println(videojuego);
        else
            System.out.println("El videojuego no existe.");
    }

    private String leerFecha() {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intenta con YYYY-MM-DD:");
            }
        }
    }
}
