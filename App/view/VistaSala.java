package App.view;

import App.model.Sala;

import java.util.List;
import java.util.Scanner;

public class VistaSala {
    public Scanner scanner;

    public VistaSala() {
        scanner = new Scanner(System.in);
    }

    public void mostrarSalas(List<Sala> salas) {
        System.out.println("Lista de Salas:");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    public Sala crearSala() {
        System.out.println("Introduce el tamaño número de la sala");
        int n_sala = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el tamaño de la sala:");
        int tamanyo = Integer.parseInt(scanner.nextLine());

        return new Sala(n_sala, tamanyo);
    }

    public int obtenerNSalaAEliminar() {
        System.out.println("Introduce el número de sala a eliminar");
        return scanner.nextInt();
    }

    public Sala obtenerDatosActualizados() {
        System.out.println("Introduce el tamaño número de la sala");
        int n_sala = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el tamaño de la sala:");
        int tamanyo = Integer.parseInt(scanner.nextLine());

        return new Sala(n_sala, tamanyo);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerNSala() {
        System.out.println("Introduce el número de sala de la sala:");
        return scanner.nextInt();
    }
    //muestra los datos de la persona
    public void mostrarSala(Sala sala) {
        if(sala!=null)
            System.out.println(sala);
        else
            System.out.println("La sala no existe");
    }

    // Otros métodos de la vista...
}
