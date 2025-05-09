package App;

import App.controller.ControllerProveedores;

import java.util.Scanner;

/**
 * Clase de prueba para la gestión de proveedores.
 * Proporciona un menú interactivo por consola para realizar operaciones CRUD sobre proveedores
 * mediante el uso del ControllerProveedores.
 * Permite mostrar, crear, actualizar, eliminar y buscar proveedores por NIF.
 *
 * @author Emilio, Pablo, Sergio
 */
public class TestProveedor {
    /**
     * Método principal que ejecuta el menú interactivo de gestión de proveedores.
     * Muestra opciones por consola que permiten al usuario gestionar proveedores registrados en el sistema.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        ControllerProveedores controlador = new ControllerProveedores();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los proveedores");
            System.out.println("2. Crear proveedor");
            System.out.println("3. Actualizar proveedor");
            System.out.println("4. Eliminar proveedor");
            System.out.println("5. Mostrar proveedor por NIF");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosProveedores();
                    break;
                case 2:
                    controlador.crearProveedor();
                    System.out.println("Cliente creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarProveedor();
                    System.out.println("Cliente actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarProveedor();
                    System.out.println("Cliente eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarProveedorNIF();
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
