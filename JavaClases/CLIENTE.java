package JavaClases;

/**
 * 
 */
public class CLIENTE {
    private int cod_cliente;
    private String dni;
    private String nombre;



    /**
     * Default constructor
     */
    public CLIENTE(int cod_cliente, String dni, String nombre) {
        this.cod_cliente = cod_cliente;
        this.dni = dni;
        this.nombre = nombre;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"cod_cliente\": ").append(cod_cliente).append(",\n")
                .append("    \"dni\": \"").append(dni).append("\",\n")
                .append("    \"nombre\": ").append(nombre).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Cliente>\n")
                .append("    <cod_cliente>").append(cod_cliente).append("</cod_cliente>\n")
                .append("    <dni>").append(dni).append("</dni>\n")
                .append("    <nombre>").append(nombre).append("</precio>\n")
                .append("</Cliente>");
        return xmlBuilder.toString();
    }

    /**
     * 
     */
    public void registrarCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void borrarCliente() {
        // TODO implement here
    }

}