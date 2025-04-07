package App.model;

/**
 * Clase que representa un Videojuego en el sistema.
 * @author Emilio, Pablo, Sergio
 */
public class Videojuego extends Producto {

    private Consola consolaReemplazar;

    // Propiedades

    private String f_lanzamiento;

    /**
     * Constructor por defecto de la clase videojuego
     *
     * @param nombre
     * @param precio
     * @param unidades
     */
    public Videojuego(String nombre, int precio, int unidades, String f_lanzamiento, Proveedor proveedor, Empleado empleado) {
        super(nombre, precio, unidades, proveedor, empleado);
        this.f_lanzamiento = f_lanzamiento;
    }

    /**
     * Convierte los datos del videojuego a formato JSON.
     *
     * @return Representación JSON del videojuego.
     */
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

    /**
     * Convierte los datos del videojuego a formato XML.
     *
     * @return Representación XML del videojuego.
     */
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
