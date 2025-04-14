package App.view;

import App.db.ProductoDAO;
import App.model.Cliente;
import App.model.LineaVenta;
import App.model.Producto;

import java.util.List;
import java.util.Scanner;

public class VistaLineaVenta {
    public Scanner scanner;

    public VistaLineaVenta() {
        scanner = new Scanner(System.in);
    }

    public void mostrarLineasVentas(List<LineaVenta> lineaVentas) {
        System.out.println("Lista de lineas de venta:");
        for (LineaVenta lv : lineaVentas) {
            System.out.println(lv);
        }
    }

    public LineaVenta crearLineaVenta(Producto producto) {
        System.out.println("Introduce la cantidad:");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el total: ");
        double total = Integer.parseInt(scanner.nextLine());

        return new LineaVenta(producto, cantidad, total);
    }

    public int obtenerCod_ProductoAEliminar() {
        System.out.println("Introduce el codigo del producto a eliminar:");
        return scanner.nextInt();
    }

    public LineaVenta obtenerDatosActualizados(Producto producto) {
        System.out.println("Introduce la nueva cantidad:");
        int cantidad = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo total: ");
        double total = Integer.parseInt(scanner.nextLine());

        return new LineaVenta(producto, cantidad, total);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerCodProducto() {
        System.out.println("Introduce el codigo del producto:");
        return scanner.nextInt();
    }

    public void mostrarLineaVenta(LineaVenta lineaVenta) {
        if(lineaVenta!=null)
            System.out.println(lineaVenta);
        else
            System.out.println("La linea de venta no existe");
    }
}
