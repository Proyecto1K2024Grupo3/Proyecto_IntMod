package App;

import App.controller.ControllerLineaVenta;

import java.util.Scanner;

/**
 * Clase de prueba para la gestión de líneas de venta.
 * Proporciona un menú por consola para interactuar con las líneas de venta mediante ControllerLineaVenta.
 * Permite realizar operaciones como mostrar, crear, actualizar, eliminar y buscar líneas de venta por código de producto.
 *
 * @author Emilio, Pablo, Sergio
 */
public class TestLineaVenta {
    /**
     * Método principal que ejecuta la aplicación de prueba para líneas de venta.
     * Muestra un menú interactivo en consola que permite gestionar las líneas de venta.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        ControllerLineaVenta controlador = new ControllerLineaVenta();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todas las lineas de venta");
            System.out.println("2. Crear linea de venta");
            System.out.println("3. Actualizar linea de venta");
            System.out.println("4. Eliminar linea de venta");
            System.out.println("5. Mostrar linea de venta por codigo de producto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodasLasLineasDeVenta();
                    break;
                case 2:
                    controlador.crearLineaVenta();
                    System.out.println("Cliente creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarLineaVenta();
                    System.out.println("Cliente actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarLineaVenta();
                    System.out.println("Cliente eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarLineaCodProducto();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
