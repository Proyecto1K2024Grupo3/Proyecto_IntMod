package App.model;

public class Sala {

    private int n_sala;
    private int tamanyo;

    public Sala(int n_sala, int tamanyo) {
        this.n_sala = n_sala;
        this.tamanyo = tamanyo;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("(\n")
                .append("    \"n_sala\": ").append(getN_sala()).append(",\n")
                .append("    \"tamanyo\": \"").append(getTamanyo()).append("\",\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Sala>\n")
                .append("    <nSala>").append(getN_sala()).append("</precio>\n")
                .append("    <unidades>").append(getTamanyo()).append("</unidades>\n")
                .append("</Sala>");
        return xmlBuilder.toString();
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public int getN_sala() {
        return n_sala;
    }

    public void setN_sala(int n_sala) {
        this.n_sala = n_sala;
    }
}
