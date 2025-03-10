package JavaClases;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa una venta.
 */
public class Venta {
    private int idVenta;
    private Cliente comprador;
    private List<LineaVenta> lineasVenta;
    private LocalDate fecha;
    private double total;
    private String metodoPago;

    /**
     * Constructor de la clase Venta.
     * @param idVenta Identificador de la venta.
     * @param comprador Cliente que realiza la compra.
     * @param lineasVenta Lista de líneas de venta.
     * @param fecha Fecha de la venta.
     * @param total Precio total de la venta.
     * @param metodoPago Método de pago utilizado.
     */
    public Venta(int idVenta, Cliente comprador, List<LineaVenta> lineasVenta, LocalDate fecha, double total, String metodoPago) {
        this.idVenta = idVenta;
        this.comprador = comprador;
        this.lineasVenta = lineasVenta;
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(List<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    // Métodos para exportar a JSON y XML
    public String toJson() {
        return "{" +
                "\"idVenta\": " + idVenta + ", " +
                "\"fecha\": \"" + fecha + "\", " +
                "\"total\": " + total + ", " +
                "\"metodoPago\": \"" + metodoPago + "\"" +
                "}";
    }

    public String toXML() {
        return "<Venta>" +
                "<idVenta>" + idVenta + "</idVenta>" +
                "<fecha>" + fecha + "</fecha>" +
                "<total>" + total + "</total>" +
                "<metodoPago>" + metodoPago + "</metodoPago>" +
                "</Venta>";
    }

    /**
     * Método para crear una venta.
     */
    public void crearVenta() {
        // Implementación futura
    }

    /**
     * Método para borrar una venta.
     */
    public void borrarVenta() {
        // Implementación futura
    }

    /**
     * Método para actualizar una venta.
     */
    public void actualizarVenta() {
        // Implementación futura
    }
}
