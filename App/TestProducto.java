package App;

import App.controller.ControllerProducto;

import java.util.Scanner;

public class TestProducto {
    public static void main(String[] args) {
        ControllerProducto controlador = new ControllerProducto();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todas los productos");
            System.out.println("2. Crear producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar producto por codigo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodosLosProductos();
                    break;
                case 2:
                    controlador.crearProducto();
                    System.out.println("Producto creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarProducto();
                    System.out.println("Producto actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarProducto();
                    System.out.println("Producto eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostrarProductoCod();
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

