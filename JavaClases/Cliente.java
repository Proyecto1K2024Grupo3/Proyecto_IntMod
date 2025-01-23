package JavaClases;

/**
 * 
 */
public class Cliente {
    private int cod_cliente;
    private String dni;
    private String nombre;



    /**
     * Default constructor
     */
    public Cliente(int cod_cliente, String dni, String nombre) {
        this.cod_cliente = cod_cliente;
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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


    public void registrarCliente() {
        // TODO implement here
    }


    public void borrarCliente() {
        // TODO implement here
    }

}