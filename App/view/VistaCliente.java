package App.view;

import App.model.Cliente;

import java.util.List;
import java.util.Scanner;

/**
 * Clase que gestiona la interacción con el usuario para operaciones relacionadas con clientes.
 * @author Emilio, Pablo, Sergio
 */
public class VistaCliente {

    public Scanner scanner;

    /**
     * Constructor desparametizado que inicializa el scanner de la clase
     */
    public VistaCliente() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra una lista de clientes por consola.
     *
     * @param clientes Lista de objetos Cliente a mostrar.
     */
    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Solicita al usuario los datos de un nuevo cliente y los devuelve como objeto.
     *
     * @return Cliente creado con los datos introducidos.
     */
    public Cliente crearCliente() {
        System.out.println("Introduce el cod_cliente:");
        int cod_cliente = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        return new Cliente(cod_cliente, nombre, dni);
    }

    /**
     * Solicita al usuario el DNI del cliente que desea eliminar.
     *
     * @return DNI del cliente como cadena.
     */
    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI del cliente a eliminar:");
        return scanner.nextLine();
    }

    /**
     * Solicita al usuario los datos actualizados de un cliente.
     *
     * @return Cliente con los nuevos datos.
     */
    public Cliente obtenerDatosActualizados() {
        System.out.println("Introduce el cod_cliente:");
        int cod_cliente = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();

        return new Cliente(cod_cliente, dni, nombre);
    }

    /**
     * Muestra un mensaje en consola.
     *
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita al usuario el DNI de un cliente.
     *
     * @return DNI introducido por el usuario.
     */
    public String obtenerDni() {
        System.out.println("Introduce el DNI del cliente:");
        return scanner.nextLine();
    }

    /**
     * Muestra los datos de un cliente por consola.
     *
     * @param cliente Cliente a mostrar. Si es null, se indica que no existe.
     */
    public void mostrarCliente(Cliente cliente) {
        if(cliente != null)
            System.out.println(cliente);
        else
            System.out.println("El cliente no existe");
    }

    // Otros métodos de la vista...
}
