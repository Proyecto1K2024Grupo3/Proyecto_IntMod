package App.view;

import App.model.Colaborador;

import java.util.List;
import java.util.Scanner;

public class VistaColaborador {
    private Scanner scanner;

    public VistaColaborador() {
        scanner = new Scanner(System.in);
    }

    public void mostrarColaboradores(List<Colaborador> colaboradores) {
        System.out.println("Lista de Colaboradores:");
        for (Colaborador colaborador : colaboradores) {
            System.out.println(colaborador);
        }
    }

    public Colaborador crearColaborador() {
        System.out.println("Introduce el nombre de usuario (n_usuario):");
        String nUsuario = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();

        return new Colaborador(nUsuario, nombre);
    }

    public String obtenerUsuarioAEliminar() {
        System.out.println("Introduce el nombre de usuario (n_usuario) del colaborador a eliminar:");
        return scanner.nextLine();
    }

    public Colaborador obtenerDatosActualizados() {
        System.out.println("Introduce el nombre de usuario (n_usuario):");
        String nUsuario = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();

        return new Colaborador(nUsuario, nombre);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerUsuario() {
        System.out.println("Introduce el nombre de usuario (n_usuario) del colaborador:");
        return scanner.nextLine();
    }

    public void mostrarColaborador(Colaborador colaborador) {
        if (colaborador != null) {
            System.out.println(colaborador);
        } else {
            System.out.println("El colaborador no existe.");
        }
    }

    // Otros métodos si necesitas más interacción...
}

