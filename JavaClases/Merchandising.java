package clases;

public class Merchandising extends Producto {

    /**
     * Default constructor
     */

    private String tipo;
    private double tamanyo;

    /**
     * Default constructor
     *
     * @param nombre
     * @param precio
     * @param unidades
     */
    public Merchandising(String nombre, int precio, int unidades, String tipo, double tamanyo) {
        super(nombre, precio, unidades);
        this.tipo = tipo;
        this.tamanyo = tamanyo;
    }

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

    public String getTipo() {
        return tipo;
    }

    public double getTamanyo() {
        return tamanyo;
    }
}
