package App.model;

/**
 * Clase que representa una línea de venta.
 */
public class LineaVenta {
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

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

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

