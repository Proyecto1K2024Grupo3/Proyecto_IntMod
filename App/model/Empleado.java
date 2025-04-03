package App.model;

/**
 * Clase que representa un Empleado en el sistema.
 */
public class Empleado {
    private int codEmpleado;
    private String dni;
    private String telefono;
    private String fechaNacimiento;
    private String nombre;

    /**
     * Constructor de la clase Empleado.
     *
     * @param dni Documento Nacional de Identidad del empleado.
     * @param codEmpleado Código identificador del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param fechaNacimiento Fecha de nacimiento del empleado.
     * @param nombre Nombre del empleado.
     */
    public Empleado(String dni, int codEmpleado, String telefono, String fechaNacimiento, String nombre) {
        this.dni = dni;
        this.codEmpleado = codEmpleado;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    /**
     * Obtiene el código del empleado.
     *
     * @return Código del empleado.
     */
    public int getCodEmpleado() {
        return codEmpleado;
    }

    /**
     * Establece el código del empleado.
     *
     * @param codEmpleado Nuevo código del empleado.
     */
    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    /**
     * Obtiene el DNI del empleado.
     *
     * @return DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del empleado.
     *
     * @param dni Nuevo DNI del empleado.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el teléfono del empleado.
     *
     * @return Teléfono del empleado.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del empleado.
     *
     * @param telefono Nuevo teléfono del empleado.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento del empleado.
     *
     * @return Fecha de nacimiento del empleado.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del empleado.
     *
     * @param fechaNacimiento Nueva fecha de nacimiento del empleado.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Convierte los datos del empleado a formato JSON.
     *
     * @return Representación JSON del empleado.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append("    \"codEmpleado\": ").append(codEmpleado).append(",\n")
                .append("    \"dni\": \"").append(dni).append("\",\n")
                .append("    \"telefono\": \"").append(telefono).append("\",\n")
                .append("    \"fechaNacimiento\": \"").append(fechaNacimiento).append("\",\n")
                .append("    \"nombre\": \"").append(nombre).append("\"\n")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos del empleado a formato XML.
     *
     * @return Representación XML del empleado.
     */
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
     * Metodo para registrar un empleado en el sistema.
     */
    public void registrarEmpleado() {
        // TODO implement here
    }

    /**
     * Metodo para borrar un empleado del sistema.
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