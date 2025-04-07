package App.model;

/**
 * @author: Pablo, Emilio y Sergio
 */

public class Partida {
    private int codPartida;
    private int inicio;
    private int direccion;

    /**
     * Constructor parametrizado de la clase Partida
     * @param codPartida Codigo de la partida
     * @param inicio Inicio de la partida
     * @param fin Fin de la partida
     * @param n_sala Numero de sala donde se juega la partida
     */
    public Partida(int codPartida, int inicio, int fin, int n_sala) {
        this.codPartida = codPartida;
        this.inicio = inicio;
        this.direccion = direccion;
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

    // Método getter para obtener la dirección (podría representar la orientación, rumbo, o sentido en el juego)
    public int getDireccion() {
        return direccion;
    }

    // Método setter para establecer la dirección
    public void setDireccion(int direccion) {
        this.direccion = direccion;
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
                .append("    \"direccion\": ").append(direccion).append("\n")
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
                .append("    <direccion>").append(direccion).append("</direccion>\n")
                .append("</Partida>");
        return xmlBuilder.toString();
    }

}
