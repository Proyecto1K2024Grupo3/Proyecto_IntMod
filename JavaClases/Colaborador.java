package JavaClases;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Colaborador {
    private String n_usuario;
    private String nombre;
    private List<Producto> productos;

    /**
     * Default constructor
     */
    public Colaborador(String n_usuario, String nombre) {
        this.n_usuario = n_usuario;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
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