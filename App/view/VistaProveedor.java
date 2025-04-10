package App.view;

import App.model.Proveedor;

import java.util.List;
import java.util.Scanner;

public class VistaProveedor {
    public Scanner scanner;

    public VistaProveedor() {
        scanner = new Scanner(System.in);
    }

    public void mostrarProveedores(List<Proveedor> proveedores) {
        System.out.println("Lista de proveedores:");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }

    public Proveedor crearProveedor() {
        System.out.println("Introduce el NIF:");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la dirección: ");
        String direccion = scanner.nextLine();

        return new Proveedor(nif, nombre, direccion);
    }

    public String obtenerNifAEliminar() {
        System.out.println("Introduce el NIF del proveedor a eliminar:");
        return scanner.nextLine();
    }

    public Proveedor obtenerDatosActualizados() {
        System.out.println("Introduce el NIF del proveedor:");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la nueva dirección: ");
        String direccion = scanner.nextLine();

        return new Proveedor(nif, nombre, direccion);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerNif() {
        System.out.println("Introduce el NIF del proveedor:");
        return scanner.nextLine();
    }

    public void mostrarProveedor(Proveedor proveedor) {
        if(proveedor!=null)
            System.out.println(proveedor);
        else
            System.out.println("El proveedor no existe");
    }
}
