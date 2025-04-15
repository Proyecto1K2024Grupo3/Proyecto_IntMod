package App.model;

/**
 * Clase que representa una línea de venta.
 *
 * @author Emilio, Pablo, Sergio
 */
public class LineaVenta {

    // Propiedades de la clase
    private Producto producto;
    private int cantidad;
    private double total;

    /**
     * Constructor de la clase LineaVenta.
     * @param producto Producto asociado a la línea de venta.
     * @param cantidad Cantidad del producto comprado.
     * @param total Precio total de la línea de venta.
     */
    public LineaVenta(Producto producto, int cantidad, double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    // Devuelve el producto asociado (puede ser parte de una compra o pedido)
    public Producto getProducto() {
        return producto;
    }

    // Establece el producto asociado
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Devuelve la cantidad de unidades del producto en esta transacción
    public int getCantidad() {
        return cantidad;
    }

    // Establece la cantidad de unidades del producto
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Devuelve el total correspondiente a esta línea (cantidad * precio unitario)
    public double getTotal() {
        return total;
    }

    // Establece el total correspondiente a esta línea
    public void setTotal(double total) {
        this.total = total;
    }


    // Métodos para exportar a JSON y XML
    public String toJson() {
        return "{" +
                "\"producto\": \"" + producto.getNombre() + "\", " +
                "\"cantidad\": " + cantidad + ", " +
                "\"total\": " + total +
                "}";
    }

    public String toXML() {
        return "<LineaVenta>" +
                "<producto>" + producto.getNombre() + "</producto>" +
                "<cantidad>" + cantidad + "</cantidad>" +
                "<total>" + total + "</total>" +
                "</LineaVenta>";
    }
}

