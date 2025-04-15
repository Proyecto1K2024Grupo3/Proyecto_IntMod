package App.model;

/**
 * Clase que representa un videojuego en el sistema.
 * @author Emilio, Pablo, Sergio
 */
public class Videojuego extends Producto {

    // Propiedades

    private String f_lanzamiento;

    /**
     * Constructor completo para crear un objeto Videojuego con todos los atributos, incluyendo proveedor y empleado.
     *
     * @param cod Código del producto
     * @param nombre Nombre del videojuego
     * @param precio Precio del videojuego
     * @param unidades Cantidad de unidades disponibles
     * @param f_lanzamiento Fecha de lanzamiento del videojuego
     * @param proveedor Proveedor del videojuego
     * @param empleado Empleado que gestiona el producto
     */
        public Videojuego(int cod, String nombre, int precio, int unidades, String f_lanzamiento, Proveedor proveedor, Empleado empleado) {
        super(cod, nombre, precio, unidades, proveedor, empleado);
        this.f_lanzamiento = f_lanzamiento;
    }

    /**
     * Constructor alternativo para crear un videojuego sin proveedor ni empleado.
     *
     * @param cod_producto Código del producto
     * @param precio Precio del videojuego
     * @param unidades Cantidad de unidades disponibles
     * @param nombre Nombre del videojuego
     * @param f_lanzamiento Fecha de lanzamiento del videojuego
     */
    public Videojuego(int cod_producto, double precio, int unidades, String nombre, String f_lanzamiento) {
        super(cod_producto, precio, unidades, nombre);
        this.f_lanzamiento = f_lanzamiento;
    }

    /**
     * Obtiene la fecha de lanzamiento del videojuego.
     *
     * @return Fecha de lanzamiento como String
     */
    public String getF_lanzamiento() {
        return f_lanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento del videojuego.
     *
     * @param f_lanzamiento Nueva fecha de lanzamiento
     */
    public void setF_lanzamiento(String f_lanzamiento) {
        this.f_lanzamiento = f_lanzamiento;
    }

    /**
     * Metodo que transforma la instancia de la clase a JSON
     * @return Cadena JSON
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
     * Convierte los datos de venta a formato XML.
     *
     * @return Representación XML de venta.
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

    /**
     * Devuelve una representación en cadena del objeto Sala.
     *
     * @return Cadena con los datos de la sala.
     */
    @Override
    public String toString() {
        return super.toString() + "Videojuego{" +
                "f_lanzamiento='" + f_lanzamiento + '\'' +
                '}';
    }
}
