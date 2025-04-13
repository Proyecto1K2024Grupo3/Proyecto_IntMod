package App.model;

/**
 * @author Pablo, Emilio y Sergio
 */

public class Merchandising extends Producto {

    // Propiedades de la clase
    private String tipo;
    private double tamanyo;

    /**
     * Constructor parametrizado de la clase Merchandising
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param unidades Unidades del producto
     * @param tipo Tipo de marchandising
     * @param tamanyo Tamaño del merchandising
     * @param proveedor Proveedor del producto
     * @param empleado Empleado que ha registrado el producto
     */
    public Merchandising(int cod, String nombre, int precio, int unidades, String tipo, double tamanyo, Proveedor proveedor, Empleado empleado) {
        super(cod, nombre, precio, unidades, proveedor, empleado);
        this.tipo = tipo;
        this.tamanyo = tamanyo;
    }

    // Método getter para obtener el tipo (por ejemplo, tipo de objeto, nave, terreno, etc.)
    public String getTipo() {
        return tipo;
    }

    // Método setter para establecer el tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método getter para obtener el tamaño (puede ser en unidades del juego, metros, etc.)
    public double getTamanyo() {
        return tamanyo;
    }

    // Método setter para establecer el tamaño
    public void setTamanyo(double tamanyo) {
        this.tamanyo = tamanyo;
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
                .append("    \"tipo:\": ").append(getTipo())
                .append("    \"tamanyo\": ").append(getTamanyo())
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Metodo que transforma la instancia de la clase a XML
     * @return Cadena XML
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Merch>\n")
                .append("    <precio>").append(getPrecio()).append("</precio>\n")
                .append("    <unidades>").append(getUnidades()).append("</unidades>\n")
                .append("    <nombre>").append(getNombre()).append("</nombre>\n")
                .append("    <tipo>").append(getTipo()).append("</tipo>")
                .append("    <tamanyo>").append(getTamanyo()).append("</tamanyo>")
                .append("</Merch>");
        return xmlBuilder.toString();
    }

}
