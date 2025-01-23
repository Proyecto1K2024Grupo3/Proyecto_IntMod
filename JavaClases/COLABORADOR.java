package JavaClases;

/**
 * 
 */
public class COLABORADOR {
    private String n_usuario;
    private String nombre;

    /**
     * Default constructor
     */
    public COLABORADOR(String n_usuario, String nombre) {
        this.n_usuario = n_usuario;
        this.nombre = nombre;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"n_usuario\": ").append(n_usuario).append(",\n")
                .append("    \"nombre\": ").append(nombre).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Colaborador>\n")
                .append("    <n_usuario>").append(n_usuario).append("</n_usuario>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Colaborador>");
        return xmlBuilder.toString();
    }

}