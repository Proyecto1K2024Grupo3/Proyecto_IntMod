package App;

import App.controller.ControllerColaborador;

import java.util.Scanner;

/**
 * Clase de prueba para la gestión de colaboradores.
 * Proporciona un menú interactivo por consola que permite realizar
 * operaciones CRUD sobre colaboradores mediante ControllerColaborador.
 *
 * @author Emilio, Pablo, Sergio
 */
public class TestColaborador {
    /**
     * Método principal que ejecuta la aplicación de prueba para colaboradores.
     * Muestra un menú en consola que permite al usuario interactuar con los datos de colaboradores.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        ControllerColaborador controlador = new ControllerColaborador();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú de Colaboradores:");
            System.out.println("1. Mostrar todos los colaboradores");
            System.out.println("2. Crear colaborador");
            System.out.println("3. Actualizar colaborador");
            System.out.println("4. Eliminar colaborador");
            System.out.println("5. Mostrar colaborador por nombre de usuario");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosColaboradores();
                    break;
                case 2:
                    controlador.crearColaborador();
                    break;
                case 3:
                    controlador.actualizarColaborador();
                    break;
                case 4:
                    controlador.eliminarColaborador();
                    break;
                case 5:
                    controlador.mostrarColaboradorPorUsuario();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}

