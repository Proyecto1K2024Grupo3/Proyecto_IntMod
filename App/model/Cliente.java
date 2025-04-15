package App.model;

/**
 * Clase que representa un Cliente en el sistema.
 *
 * @author Emilio, Pablo, Sergio
 */
public class Cliente {
    private int cod_cliente;
    private String dni;
    private String nombre;

    /**
     * Constructor por defecto para la clase Cliente.
     *
     * @param cod_cliente Código identificador del cliente.
     * @param dni DNI del cliente.
     * @param nombre Nombre del cliente.
     */
    public Cliente(int cod_cliente, String nombre, String dni) {
        this.cod_cliente = cod_cliente;
        this.dni = dni;
        this.nombre = nombre;
    }

    /**
     * Obtiene el código del cliente.
     *
     * @return Código del cliente.
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * Establece el código del cliente.
     *
     * @param cod_cliente Nuevo código del cliente.
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni Nuevo DNI del cliente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Convierte los datos del cliente a formato JSON.
     *
     * @return Representación JSON del cliente.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"cod_cliente\": ").append(cod_cliente).append(",\n")
                .append("    \"dni\": \"").append(dni).append("\",\n")
                .append("    \"nombre\": ").append(nombre).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos del cliente a formato XML.
     *
     * @return Representación XML del cliente.
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Cliente>\n")
                .append("    <cod_cliente>").append(cod_cliente).append("</cod_cliente>\n")
                .append("    <dni>").append(dni).append("</dni>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Cliente>");
        return xmlBuilder.toString();
    }

    /**
     * Registra un nuevo cliente en el sistema.
     */
    public void registrarCliente() {
        // TODO implement here
    }

    /**
     * Borra un cliente del sistema.
     */
    public void borrarCliente() {
        // TODO implement here
    }

    /**
     * Devuelve una representación en cadena del objeto Cliente.
     *
     * @return Cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "cod_cliente=" + cod_cliente +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
