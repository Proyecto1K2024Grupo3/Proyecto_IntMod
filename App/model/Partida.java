package App.model;

/**
 * Clase que representa una partida.
 */
public class Partida {
    private int codPartida;
    private int inicio;
    private int direccion;

    /**
     * Constructor con parámetros.
     */
    public Partida(int codPartida, int inicio, int direccion) {
        this.codPartida = codPartida;
        this.inicio = inicio;
        this.direccion = direccion;
    }

    public int getCodPartida() {
        return codPartida;
    }

    public void setCodPartida(int codPartida) {
        this.codPartida = codPartida;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"codPartida\": ").append(codPartida).append(",\n")
                .append("    \"inicio\": ").append(inicio).append(",\n")
                .append("    \"direccion\": ").append(direccion).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Partida>\n")
                .append("    <codPartida>").append(codPartida).append("</codPartida>\n")
                .append("    <inicio>").append(inicio).append("</inicio>\n")
                .append("    <direccion>").append(direccion).append("</direccion>\n")
                .append("</Partida>");
        return xmlBuilder.toString();
    }

    /**
     * Método para crear una partida.
     */
    public void crearPartida() {
        // TODO implement here
    }

    /**
     * Método para borrar una partida.
     */
    public void borrarPartida() {
        // TODO implement here
    }

    /**
     * Método para actualizar una partida.
     */
    public void actualizarPartida() {
        // TODO implement here
    }
}
