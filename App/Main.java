package App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Colaboradores");
            System.out.println("3. Gestionar Empleados");
            System.out.println("4. Gestionar Línea de Venta");
            System.out.println("5. Gestionar Merchandising");
            System.out.println("6. Gestionar Productos");
            System.out.println("7. Gestionar Proveedores");
            System.out.println("8. Gestionar Salas");
            System.out.println("9. Gestionar Videojuegos");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    App.TestCliente.main(null);
                    break;
                case 2:
                    App.TestColaborador.main(null);
                    break;
                case 3:
                    App.TestEmpleado.main(null);
                    break;
                case 4:
                    App.TestLineaVenta.main(null);
                    break;
                case 5:
                    App.TestMerchandising.main(null);
                    break;
                case 6:
                    App.TestProducto.main(null);
                    break;
                case 7:
                    App.TestProveedor.main(null);
                    break;
                case 8:
                    App.TestSala.main(null);
                    break;
                case 9:
                    App.TestVideojuego.main(null);
                    break;
                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 10);
    }
}
