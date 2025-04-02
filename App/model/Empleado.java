package App.model;

/**
 * Clase que representa un empleado.
 */
public class Empleado {
    private int codEmpleado;
    private String dni;
    private String telefono;
    private String fechaNacimiento;
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Empleado(String dni, int codEmpleado, String telefono, String fechaNacimiento, String nombre) {
        this.dni = dni;
        this.codEmpleado = codEmpleado;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"codEmpleado\": ").append(codEmpleado).append(",\n")
                .append("    \"dni\": \"").append(dni).append("\",\n")
                .append("    \"telefono\": ").append(telefono).append(",\n")
                .append("    \"fechaNacimiento\": \"").append(fechaNacimiento).append("\",\n")
                .append("    \"nombre\": \"").append(nombre).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Empleado>\n")
                .append("    <codEmpleado>").append(codEmpleado).append("</codEmpleado>\n")
                .append("    <dni>").append(dni).append("</dni>\n")
                .append("    <telefono>").append(telefono).append("</telefono>\n")
                .append("    <fechaNacimiento>").append(fechaNacimiento).append("</fechaNacimiento>\n")
                .append("    <nombre>").append(nombre).append("</nombre>\n")
                .append("</Empleado>");
        return xmlBuilder.toString();
    }

    /**
     * Método para registrar un empleado.
     */
    public void registrarEmpleado() {
        // TODO implement here
    }

    /**
     * Método para borrar un empleado.
     */
    public void borrarEmpleado() {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codEmpleado=" + codEmpleado +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
