package App;

import App.controller.ControllerEmpleado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControllerEmpleado controlador = new ControllerEmpleado();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todas los empleados");
            System.out.println("2. Crear empleado");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Mostrar empleado por DNI");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosEmpleados();
                    break;
                case 2:
                    controlador.crearEmpleado();
                    System.out.println("Persona creada correctamente.");
                    break;
                case 3:
                    controlador.actualizarEmpleado();
                    System.out.println("Persona actualizada correctamente.");
                    break;
                case 4:
                    controlador.eliminarEmpleado();
                    System.out.println("Persona eliminada correctamente.");
                    break;
                case 5:
                    controlador.mostrarEmpleadoDNI();
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
