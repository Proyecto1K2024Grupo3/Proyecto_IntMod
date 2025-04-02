package App.view;

import App.model.Empleado;

import java.util.List;
import java.util.Scanner;

public class VistaEmpleado {
    public Scanner scanner;

    public VistaEmpleado() {
        scanner = new Scanner(System.in);
    }

    public void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("Lista de Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public Empleado crearEmpleado() {
        System.out.println("Introduce el cod_empleado:");
        int cod_empleado = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Introduce la fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        return new Empleado(dni, cod_empleado, telefono, fechaNacimiento, nombre);
    }

    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI de la persona a eliminar:");
        return scanner.nextLine();
    }

    public Empleado obtenerDatosActualizados() {
        System.out.println("Introduce el cod_empleado:");
        int cod_empleado = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nuevo telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Introduce la nueva fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre: ");
        String nombre = scanner.nextLine();

        return new Empleado(dni, cod_empleado, telefono, fechaNacimiento, nombre);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerDni() {
        System.out.println("Introduce el DNI de la persona:");
        return scanner.nextLine();
    }
    //muestra los datos de la persona
    public void mostrarEmpleado(Empleado empleado) {
        if(empleado!=null)
            System.out.println(empleado);
        else
            System.out.println("La persona no existe");
    }

    // Otros métodos de la vista...
}
