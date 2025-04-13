package App.view;

import App.model.LineaVenta;
import App.model.Merchandising;

import java.util.List;
import java.util.Scanner;

public class VistaMerchandising {
    public Scanner scanner;

    public VistaMerchandising() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMerchandisings(List<Merchandising> merchandisings) {
        System.out.println("Lista de merchandisings:");
        for (Merchandising m :merchandisings) {
            System.out.println(m);
        }
    }

    public Merchandising crearMerchandising() {
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el precio:");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce las unidades: ");
        int unidades = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el tipo: ");
        String tipo = scanner.nextLine();
        System.out.println("Introduce el tamanyo: ");
        double tamanyo = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce el proveedor: ");
//        String proveedor = scanner.nextLine();
        System.out.println("Introduce un empleado: ");
//        String empleado = scanner.nextLine();

        return new Merchandising(nombre, precio, unidades, tipo, tamanyo,);
    }

    public int obtenerTipoAEliminar() {
        System.out.println("Introduce el tipo a eliminar:");
        return scanner.nextInt();
    }

    public Merchandising obtenerDatosActualizados() {
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el nuevo precio:");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce las nuevas unidades: ");
        int unidades = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo tipo: ");
        String tipo = scanner.nextLine();
        System.out.println("Introduce el nuevo tamanyo: ");
        double tamanyo = Double.parseDouble(scanner.nextLine());
        System.out.println("Introduce el nuevo proveedor: ");
//        String proveedor = scanner.nextLine();
        System.out.println("Introduce un nuevo empleado: ");
//        String empleado = scanner.nextLine();

        return new Merchandising(nombre, precio, unidades, tipo, tamanyo,);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerTipo() {
        System.out.println("Introduce el tipo del merchandising:");
        return scanner.nextLine();
    }

    public void mostrarMerchandising(Merchandising merchandising) {
        if(merchandising!=null)
            System.out.println(merchandising);
        else
            System.out.println("La linea de venta no existe");
    }
}
