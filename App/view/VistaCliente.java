package App.view;

import App.model.Cliente;
import App.model.Empleado;

import java.util.List;
import java.util.Scanner;

public class VistaCliente {
    public Scanner scanner;

    public VistaCliente() {
        scanner = new Scanner(System.in);
    }

    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public Cliente crearCliente() {
        System.out.println("Introduce el cod_cliente:");
        int cod_cliente = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        return new Cliente(cod_cliente, dni, nombre);
    }

    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI del cliente a eliminar:");
        return scanner.nextLine();
    }

    public Cliente obtenerDatosActualizados() {
        System.out.println("Introduce el cod_cliente:");
        int cod_cliente = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();

        return new Cliente(cod_cliente, dni, nombre);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerDni() {
        System.out.println("Introduce el DNI del cliente:");
        return scanner.nextLine();
    }

    public void mostrarCliente(Cliente cliente) {
        if(cliente!=null)
            System.out.println(cliente);
        else
            System.out.println("El cliente no existe");
    }

    // Otros métodos de la vista...
}
