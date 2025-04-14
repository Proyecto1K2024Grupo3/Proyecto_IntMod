package App;

import App.controller.ControllerColaborador;

import java.util.Scanner;

public class TestColaborador {
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

