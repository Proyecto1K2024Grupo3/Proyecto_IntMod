package App.model;

/**
 * Clase que representa un proveedor.
 * @author Emilio, Pablo, Sergio
 */
public class Proveedor {
    private String nif;
    private String nombre;
    private String direccion;

    /**
     * Constructor por defecto.
     * @param nif Identificador del proveedor
     * @param nombre Nombre del proveedor
     * @param direccion Dirección del proveedor
     */
    public Proveedor(String nif, String nombre, String direccion) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el NIF del proveedor.
     *
     * @return NIF del proveedor.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del proveedor.
     *
     * @param nif nuevo NIF del proveedor.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del proveedor.
     *
     * @return dirección del proveedor.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del proveedor.
     *
     * @param direccion nueva dirección del proveedor.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Convierte los datos del proveedor a formato JSON.
     *
     * @return Representación JSON del proveedor.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"nif\": \"").append(nif).append("\",\n")
                .append("    \"nombre\": \"").append(nombre).append("\",\n")
                .append("    \"direccion\": \"").append(direccion).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos del proveedor a formato XML.
     *
     * @return Representación XML del proveedor.
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Proveedor>\n")
                .append("    <nif>").append(nif).append("</nif>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("    <direccion>").append(direccion).append("</direccion>\n")
                .append("</Proveedor>");
        return xmlBuilder.toString();
    }
}
