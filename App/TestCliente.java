package App;

import App.controller.ControllerCliente;

import java.util.Scanner;

/**
 * Clase de prueba para la gestión de clientes.
 * Proporciona un menú en consola para interactuar con clientes del sistema
 * utilizando el controlador ControllerCliente.
 *
 * Permite realizar operaciones CRUD sobre clientes.
 *
 * @author Emilio, Pablo, Sergio
 */
public class TestCliente {
    /**
     * Método principal que ejecuta la aplicación de prueba para clientes.
     * Muestra un menú interactivo en consola para realizar acciones como crear,
     * mostrar, actualizar o eliminar clientes.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        ControllerCliente controlador = new ControllerCliente();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los clientes");
            System.out.println("2. Crear cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Mostrar cliente por DNI");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosClientes();
                    break;
                case 2:
                    controlador.crearCliente();
                    System.out.println("Cliente creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarCliente();
                    System.out.println("Cliente actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarCliente();
                    System.out.println("Cliente eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarClienteDNI();
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
