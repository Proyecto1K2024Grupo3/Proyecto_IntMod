package App.model;

/**
 *
 */
public class Videojuego extends Producto {

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
        public Videojuego(int cod, String nombre, int precio, int unidades, String f_lanzamiento, Proveedor proveedor, Empleado empleado) {
        super(cod, nombre, precio, unidades, proveedor, empleado);
        this.f_lanzamiento = f_lanzamiento;
    }

    public Videojuego(int cod_producto, double precio, int unidades, String nombre, String f_lanzamiento) {
        super(cod_producto, precio, unidades, nombre);
        this.f_lanzamiento = f_lanzamiento;
    }

    public String getF_lanzamiento() {
        return f_lanzamiento;
    }

    public void setF_lanzamiento(String f_lanzamiento) {
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

    @Override
    public String toString() {
        return super.toString() + "Videojuego{" +
                "f_lanzamiento='" + f_lanzamiento + '\'' +
                '}';
    }
}
