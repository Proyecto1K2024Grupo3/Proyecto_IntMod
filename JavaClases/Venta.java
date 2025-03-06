package JavaClases;

/**
 * Clase que representa una venta.
 */
public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private String metodoPago;

    /**
     * Constructor por defecto.
     */
    public Venta(int idVenta, String fecha, double total, String metodoPago) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"idVenta\": ").append(idVenta).append(",\n")
                .append("    \"fecha\": \"").append(fecha).append("\",\n")
                .append("    \"total\": ").append(total).append(",\n")
                .append("    \"metodoPago\": \"").append(metodoPago).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Venta>\n")
                .append("    <idVenta>").append(idVenta).append("</idVenta>\n")
                .append("    <fecha>").append(fecha).append("</fecha>\n")
                .append("    <total>").append(total).append("</total>\n")
                .append("    <metodoPago>").append(metodoPago).append("</metodoPago>\n")
                .append("</Venta>");
        return xmlBuilder.toString();
    }

    /**
     * Método para crear una venta.
     */
    public void crearVenta() {
        // TODO implement here
    }

    /**
     * Método para borrar una venta.
     */
    public void borrarVenta() {
        // TODO implement here
    }

    /**
     * Método para actualizar una venta.
     */
    public void actualizarVenta() {
        // TODO implement here
    }
}
