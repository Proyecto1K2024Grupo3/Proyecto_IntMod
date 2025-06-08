package App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Usar Cliente");
            System.out.println("2. Usar Colaborador");
            System.out.println("3. Usar LineaVenta");
            System.out.println("4. Usar Merchandising");
            System.out.println("5. Usar Producto");
            System.out.println("6. Usar Proveedor");
            System.out.println("7. Usar Sala");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    TestCliente.main(null);
                    break;
                case 2:
                    TestColaborador.main(null);
                    break;
                case 3:
                    TestLineaVenta.main(null);
                    break;
                case 4:
                    TestMerchandising.main(null);
                    break;
                case 5:
                    TestProducto.main(null);
                    break;
                case 6:
                    TestProveedor.main(null);
                    break;
                case 7:
                    TestSala.main(null);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
}
