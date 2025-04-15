package App.model;

/**
 * Clase que representa una partida.
 *
 * @author: Pablo, Emilio y Sergio
 */

public class Partida {
    private int codPartida;
    private int inicio;
    private int fin;
    private Sala sala;

    /**
     *
     * @param codPartida
     * @param inicio
     * @param fin
     * @param sala
     */
    public Partida(int codPartida, int inicio, int fin, Sala sala) {
        this.codPartida = codPartida;
        this.inicio = inicio;
        this.fin = fin;
        this.sala = sala;
    }

    // Método getter para obtener el código de la partida
    public int getCodPartida() {
        return codPartida;
    }

    // Método setter para establecer el código de la partida
    public void setCodPartida(int codPartida) {
        this.codPartida = codPartida;
    }

    // Método getter para obtener el valor de inicio (puede representar el turno inicial, posición, etc.)
    public int getInicio() {
        return inicio;
    }

    // Método setter para establecer el valor de inicio
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Metodo que transforma la instancia de la clase a JSON
     * @return Cadena JSON
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"codPartida\": ").append(codPartida).append(",\n")
                .append("    \"inicio\": ").append(inicio).append(",\n")
                .append("    \"fin\": ").append(fin).append("\n")
                .append("    \"n_sala\": ").append(sala.getN_sala()).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Metodo que transforma la instancia de la clase a XML
     * @return Cadena XML
     */
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Partida>\n")
                .append("    <codPartida>").append(codPartida).append("</codPartida>\n")
                .append("    <inicio>").append(inicio).append("</inicio>\n")
                .append("    <fin>").append(fin).append("</fin>\n")
                .append("</Partida>");
        return xmlBuilder.toString();
    }



}
