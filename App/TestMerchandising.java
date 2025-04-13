package App;

import App.controller.ControllerLineaVenta;
import App.controller.ControllerMerchandising;

import java.util.Scanner;

public class TestMerchandising {
    public static void main(String[] args) {
        ControllerMerchandising controlador = new ControllerMerchandising();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los merchandising");
            System.out.println("2. Crear merchandising");
            System.out.println("3. Actualizar merchandising");
            System.out.println("4. Eliminar merchandising");
            System.out.println("5. Mostrar merchandising por tipo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosMerchandising();
                    break;
                case 2:
                    controlador.crearMerchandising();
                    System.out.println("Cliente creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarMerchandising();
                    System.out.println("Cliente actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarMerchandising();
                    System.out.println("Cliente eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarMerchandisingByTipo();
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
