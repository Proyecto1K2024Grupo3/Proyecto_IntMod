package App.model;

/**
 * Clase que representa una Consola, la cual es un tipo de Producto en el sistema.
 *
 * @author Emilio, Pablo, Sergio
 */
public class Consola extends Producto {

    private Consola consolaReemplazar;

    /**
     * Constructor de la clase Consola.
     *
     * @param nombre Nombre de la consola.
     * @param precio Precio de la consola.
     * @param unidades Cantidad de unidades disponibles.
     * @param proveedor Proveedor de la consola.
     * @param empleado Empleado asociado a la consola.
     */
    public Consola(int cod, String nombre, int precio, int unidades, Proveedor proveedor, Empleado empleado) {
        super(cod, nombre, precio, unidades, proveedor, empleado);
    }

    /**
     * Constructor de la clase Consola con una consola a reemplazar.
     *
     * @param nombre Nombre de la consola.
     * @param precio Precio de la consola.
     * @param unidades Cantidad de unidades disponibles.
     * @param proveedor Proveedor de la consola.
     * @param empleado Empleado asociado a la consola.
     * @param consolaReemplazar Consola que será reemplazada.
     */
    public Consola(int cod, String nombre, int precio, int unidades, Proveedor proveedor, Empleado empleado, Consola consolaReemplazar) {
        super(cod, nombre, precio, unidades, proveedor, empleado);
        this.consolaReemplazar = consolaReemplazar;
    }

    /**
     * Convierte los datos de la consola a formato JSON.
     *
     * @return Representación JSON de la consola.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"precio\": ").append(getPrecio()).append(",\n")
                .append("    \"unidades\": ").append(getUnidades()).append(",\n")
                .append("    \"nombre\": \"").append(getNombre()).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos de la consola a formato XML.
     *
     * @return Representación XML de la consola.
     */
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
