package App;

import App.controller.ControllerSala;

import java.util.Scanner;

/**
 * Clase de prueba para la gestión de salas.
 * Proporciona un menú interactivo por consola para realizar operaciones CRUD sobre salas
 * mediante el uso del ControllerSala.
 * Permite mostrar, crear, actualizar, eliminar y buscar salas por número.
 *
 * @author Emilio, Pablo, Sergio
 */
public class TestSala {
    /**
     * Método principal que ejecuta el menú interactivo de gestión de salas.
     * Muestra opciones por consola que permiten al usuario gestionar salas en el sistema.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        ControllerSala controlador = new ControllerSala();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todas las salas");
            System.out.println("2. Crear sala");
            System.out.println("3. Actualizar sala");
            System.out.println("4. Eliminar sala");
            System.out.println("5. Mostrar sala por número de sala");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodasLasSalas();
                    break;
                case 2:
                    controlador.crearSala();
                    System.out.println("Sala creada correctamente.");
                    break;
                case 3:
                    controlador.actualizarSala();
                    System.out.println("Sala actualizada correctamente.");
                    break;
                case 4:
                    controlador.eliminarSala();
                    System.out.println("Sala eliminada correctamente.");
                    break;
                case 5:
                    controlador.mostrarSalaPorNSala();
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
