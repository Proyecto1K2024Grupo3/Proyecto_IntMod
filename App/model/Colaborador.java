package App.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Colaborador en el sistema.
 *
 * @author Emilio, Pablo, Sergio
 */
public class Colaborador {
    private String n_usuario;
    private String nombre;
    private List<Producto> productos;

    /**
     * Constructor por defecto para la clase Colaborador.
     *
     * @param n_usuario Nombre de usuario del colaborador.
     * @param nombre Nombre del colaborador.
     */
    public Colaborador(String n_usuario, String nombre) {
        this.n_usuario = n_usuario;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    /**
     * Obtiene el nombre de usuario del colaborador.
     *
     * @return Nombre de usuario del colaborador.
     */
    public String getN_usuario() {
        return n_usuario;
    }

    /**
     * Establece el nombre de usuario del colaborador.
     *
     * @param n_usuario Nuevo nombre de usuario del colaborador.
     */
    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
    }

    /**
     * Obtiene el nombre del colaborador.
     *
     * @return Nombre del colaborador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del colaborador.
     *
     * @param nombre Nuevo nombre del colaborador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Convierte los datos del colaborador a formato JSON.
     *
     * @return Representación JSON del colaborador.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"n_usuario\": \"").append(n_usuario).append("\",\n")
                .append("    \"nombre\": \"").append(nombre).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos del colaborador a formato XML.
     *
     * @return Representación XML del colaborador.
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Colaborador>\n")
                .append("    <n_usuario>").append(n_usuario).append("</n_usuario>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Colaborador>");
        return xmlBuilder.toString();
    }
}
