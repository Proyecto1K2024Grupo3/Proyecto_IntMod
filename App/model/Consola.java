package App.model;


public class Consola extends Producto {

    private Consola consolaReemplazar;

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
    public Consola(String nombre, int precio, int unidades, Proveedor proveedor, Empleado empleado) {
        super(nombre, precio, unidades, proveedor, empleado);
    }

    public Consola(String nombre, int precio, int unidades, Proveedor proveedor, Empleado empleado, Consola consolaReemplazar) {
        super(nombre, precio, unidades, proveedor, empleado);
        this.consolaReemplazar = consolaReemplazar;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"precio\": ").append(getPrecio()).append(",\n")
                .append("    \"unidades\": \"").append(getUnidades()).append("\",\n")
                .append("    \"nombre\": ").append(getNombre()).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Consola>\n")
                .append("    <precio>").append(getPrecio()).append("</precio>\n")
                .append("    <unidades>").append(getUnidades()).append("</unidades>\n")
                .append("    <nombre>").append(getNombre()).append("</nombre>\n")
                .append("</Consola>");
        return xmlBuilder.toString();
    }
}
