package App.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa una venta en el sistema.
 * @author Emilio, Pablo, Sergio
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

    /**
     * Obtiene el ID de la venta.
     *
     * @return idVenta de la venta.
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el ID de la venta.
     *
     * @param idVenta Nuevo ID de la venta.
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Obtiene el ID del comprador de la venta.
     *
     * @return comprador de la venta.
     */
    public Cliente getComprador() {
        return comprador;
    }

    /**
     * Establece el ID del comprador de la venta.
     *
     * @param comprador comprador de la venta nueva.
     */
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    /**
     * Obtiene la linea de venta de la venta.
     *
     * @return linea de ventas de la venta.
     */
    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    /**
     * Establece la línea de ventas de la venta.
     *
     * @param lineasVenta Nueva linea de ventas de la venta.
     */
    public void setLineasVenta(List<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return fecha de la venta.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fecha Nueva fecha de la venta.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el total de la venta.
     *
     * @return total de la venta.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     *
     * @param total Nuevo total de la venta.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene el pago de la venta.
     *
     * @return pago de la venta.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Establece el pago de la venta.
     *
     * @param metodoPago Nuevo pago de la venta.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }


    /**
     * Convierte los datos de venta  a formato JSON.
     *
     * @return Representación JSON de venta.
     */
    // Métodos para exportar a JSON y XML
    public String toJson() {
        return "{" +
                "\"idVenta\": " + idVenta + ", " +
                "\"fecha\": \"" + fecha + "\", " +
                "\"total\": " + total + ", " +
                "\"metodoPago\": \"" + metodoPago + "\"" +
                "}";
    }

    /**
     * Convierte los datos de venta a formato XML.
     *
     * @return Representación XML de venta.
     */
    public String toXML() {
        return "<Venta>" +
                "<idVenta>" + idVenta + "</idVenta>" +
                "<fecha>" + fecha + "</fecha>" +
                "<total>" + total + "</total>" +
                "<metodoPago>" + metodoPago + "</metodoPago>" +
                "</Venta>";
    }
}
