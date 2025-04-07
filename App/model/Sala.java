package App.model;

/**
 * Clase que representa una sala en el sistema.
 * @author Emilio, Pablo, Sergio
 */
public class Sala {

    private int n_sala;
    private int tamanyo;

    /**
     * Constructor de la clase Sala.
     * @param n_sala Identificador de la sala.
     * @param tamanyo Tamaño de sala que realiza una partida.
     */
    public Sala(int n_sala, int tamanyo) {
        this.n_sala = n_sala;
        this.tamanyo = tamanyo;
    }

    /**
     * Convierte los datos de la sala a formato JSON.
     *
     * @return Representación JSON de la sala.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"n_sala\": ").append(getN_sala()).append(",\n")
                .append("    \"tamanyo\": \"").append(getTamanyo()).append("\",\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos de la sala a formato XML.
     *
     * @return Representación XML de la sala.
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Sala>\n")
                .append("    <nSala>").append(getN_sala()).append("</precio>\n")
                .append("    <unidades>").append(getTamanyo()).append("</unidades>\n")
                .append("</Sala>");
        return xmlBuilder.toString();
    }

    /**
     * Obtiene el tamaño de la sala.
     *
     * @return tamanyo de la sala.
     */
    public int getTamanyo() {
        return tamanyo;
    }

    /**
     * Establece el tamaño de la sala.
     *
     * @param tamanyo nuevo tamaño de la sala.
     */
    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    /**
     * Obtiene el número de la sala.
     *
     * @return número de la sala.
     */
    public int getN_sala() {
        return n_sala;
    }

    /**
     * Establece el número de la sala.
     *
     * @param n_sala nuevo número de la sala.
     */
    public void setN_sala(int n_sala) {
        this.n_sala = n_sala;
    }

    /**
     * Devuelve una representación en cadena del objeto Sala.
     *
     * @return Cadena con los datos de la sala.
     */
    @Override
    public String toString() {
        return "Sala{" +
                "n_sala=" + n_sala +
                ", tamanyo=" + tamanyo +
                '}';
    }
}
