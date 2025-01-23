package JavaClases;

/**
 * 
 */
public class PRODUCTO {
    private int precio;
    private int unidades;
    private String nombre;


    /**
     * Default constructor
     */
    public PRODUCTO(String nombre, int precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"precio\": ").append(precio).append(",\n")
                .append("    \"unidades\": \"").append(unidades).append("\",\n")
                .append("    \"nombre\": ").append(nombre).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Producto>\n")
                .append("    <precio>").append(precio).append("</precio>\n")
                .append("    <unidades>").append(unidades).append("</unidades>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Producto>");
        return xmlBuilder.toString();
    }

    /**
     * 
     */
    public void crearProducto() {
        // TODO implement here
    }

    /**
     * 
     */
    public void borrarProducto() {
        // TODO implement here
    }

    /**
     * 
     */
    public void actualizarProducto() {
        // TODO implement here
    }

}