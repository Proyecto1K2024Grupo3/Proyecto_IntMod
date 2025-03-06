package JavaClases;

/**
 * Clase que representa un proveedor.
 */
public class Proveedor {
    private String nif;
    private String nombre;
    private String direccion;

    /**
     * Constructor por defecto.
     */
    public Proveedor(String nif, String nombre, String direccion) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"nif\": \"").append(nif).append("\",\n")
                .append("    \"nombre\": \"").append(nombre).append("\",\n")
                .append("    \"direccion\": \"").append(direccion).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

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
