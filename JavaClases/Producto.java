package JavaClases;

/**
 * 
 */
public class Producto {
    private int precio;
    private int unidades;
    private String nombre;
    private Proveedor provedor;
    private Empleado empleadoRegistro;


    /**
     * Default constructor
     */
    public Producto(String nombre, int precio, int unidades, Proveedor proveedor, Empleado empleadoRegistro) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.provedor = proveedor;
        this.empleadoRegistro = empleadoRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
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