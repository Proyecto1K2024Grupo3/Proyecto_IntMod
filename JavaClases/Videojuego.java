package JavaClases;

/**
 *
 */
public class Videojuego extends Producto {

    private Consola consolaReemplazar;

    // Propiedades

    private String f_lanzamiento;

    /**
     * Default constructor
     */

    /**
     * Default constructor
     *
     * @param nombre
     * @param precio
     * @param unidades
     */

        public Videojuego(String nombre, int precio, int unidades, String f_lanzamiento, Proveedor proveedor, Empleado empleado) {
        super(nombre, precio, unidades, proveedor, empleado);
        this.f_lanzamiento = f_lanzamiento;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"precio\": ").append(getPrecio()).append(",\n")
                .append("    \"unidades\": \"").append(getUnidades()).append("\",\n")
                .append("    \"nombre\": ").append(getNombre()).append("\n")
                .append("    \"f_lanzamiento\": ").append(f_lanzamiento).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Videojuego>\n")
                .append("    <precio>").append(getPrecio()).append("</precio>\n")
                .append("    <unidades>").append(getUnidades()).append("</unidades>\n")
                .append("    <nombre>").append(getNombre()).append("</nombre>\n")
                .append("    <f_lanzamiento>").append(f_lanzamiento).append("</nombre>\n")
                .append("</Videojuego>");
        return xmlBuilder.toString();
    }
}
