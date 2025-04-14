package App.view;

import App.model.LineaVenta;
import App.model.Merchandising;
import App.model.Producto;


import java.util.List;
import java.util.Scanner;

public class VistaMerchandising {
    public Scanner scanner;
    private VistaProducto vistaProducto;

    public VistaMerchandising() {
        this.vistaProducto = new VistaProducto();
        scanner = new Scanner(System.in);
    }

    public void mostrarMerchandisings(List<Merchandising> merchandisings) {
        System.out.println("Lista de merchandisings:");
        for (Merchandising m :merchandisings) {
            System.out.println(m);
        }
    }

    public Merchandising crearMerchandising() {
        Producto producto = vistaProducto.crearProductos();
        System.out.println("Tipo del merchandising: ");
        String tipo = scanner.nextLine();
        System.out.println("Tamaño del merchandising: ");
        Double tamanyo = Double.parseDouble(scanner.nextLine());

        return new Merchandising(producto.getCod_producto(), producto.getNombre(), producto.getPrecio(), producto.getUnidades(), tipo, tamanyo);
    }

    public int obtenerTipoAEliminar() {
        System.out.println("Introduce el tipo a eliminar:");
        return scanner.nextInt();
    }

    public Merchandising obtenerDatosActualizados() {
        Producto producto = vistaProducto.obtenerDatosActualizados();
        System.out.println("Nuevo tipo del merchandising: ");
        String tipo = scanner.nextLine();
        System.out.println("Nuevo tamaño del merchandising: ");
        Double tamanyo = Double.parseDouble(scanner.nextLine());

        return new Merchandising(producto.getCod_producto(), producto.getNombre(), producto.getPrecio(), producto.getUnidades(), tipo, tamanyo);
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
