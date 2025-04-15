package App.model;

/**
 * Clase que representa un producto.
 *
 * @author Pablo, Emilio y Sergio
 */
public class Producto {
    private int cod_producto;
    private double precio;
    private int unidades;
    private String nombre;
    private Proveedor provedor;
    private Empleado empleadoRegistro;

    /**
     * Contructor parametrizado de la clase producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param unidades Unidades del producto
     * @param proveedor Proovedor del producto
     * @param empleadoRegistro Empleado que ha registrado
     */
    public Producto(int cod_producto, String nombre, double precio, int unidades, Proveedor proveedor, Empleado empleadoRegistro) {
        this.cod_producto = cod_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.provedor = proveedor;
        this.empleadoRegistro = empleadoRegistro;
    }

    public Producto(int cod_producto, double precio, int unidades, String nombre) {
        this.cod_producto = cod_producto;
        this.precio = precio;
        this.unidades = unidades;
        this.nombre = nombre;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    // Devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el precio del producto (en la unidad monetaria que uses, por ejemplo euros)
    public double getPrecio() {
        return precio;
    }

    // Establece el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Devuelve la cantidad de unidades disponibles del producto
    public int getUnidades() {
        return unidades;
    }

    // Establece la cantidad de unidades disponibles del producto
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    // Devuelve el proveedor asociado al producto
    public Proveedor getProvedor() {
        return provedor;
    }

    // Establece el proveedor que suministra el producto
    public void setProvedor(Proveedor provedor) {
        this.provedor = provedor;
    }

    // Devuelve el empleado que registró el producto
    public Empleado getEmpleadoRegistro() {
        return empleadoRegistro;
    }

    // Establece el empleado responsable del registro del producto
    public void setEmpleadoRegistro(Empleado empleadoRegistro) {
        this.empleadoRegistro = empleadoRegistro;
    }

    /**
     * Metodo que transforma la instancia de la clase a JSON
     * @return Cadena JSON
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"precio\": ").append(precio).append(",\n")
                .append("    \"unidades\": \"").append(unidades).append("\",\n")
                .append("    \"nombre\": ").append(nombre).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Metodo que transforma la instancia de la clase a XML
     * @return Cadena XML
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Producto>\n")
                .append("    <precio>").append(precio).append("</precio>\n")
                .append("    <unidades>").append(unidades).append("</unidades>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Producto>");
        return xmlBuilder.toString();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cod_producto=" + cod_producto +
                ", precio=" + precio +
                ", unidades=" + unidades +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
