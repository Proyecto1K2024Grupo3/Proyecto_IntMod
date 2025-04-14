package App;

import App.controller.ControllerVideojuego;

import java.util.Scanner;

public class TestVideojuego {
    public static void main(String[] args) {
        ControllerVideojuego controlador = new ControllerVideojuego();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los videojuegos");
            System.out.println("2. Crear videojuego");
            System.out.println("3. Actualizar videojuego");
            System.out.println("4. Eliminar videojuego");
            System.out.println("5. Mostrar videojuego por código");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosVideojuegos();
                    break;
                case 2:
                    controlador.crearVideojuego();
                    System.out.println("Videojuego creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarVideojuego();
                    System.out.println("Videojuego actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarVideojuego();
                    System.out.println("Videojuego eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarVideojuegoPorCodigo();
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

