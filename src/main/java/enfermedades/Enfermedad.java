package enfermedades;

public class Enfermedad {

    private String nombre;
    private String descripcion;
    private String tratamientos;
    private String medicamento;
    private String dosis;

    public Enfermedad() {
    }

    public Enfermedad(String nombre, String descripcion, String tratamientos, String medicamento, String dosis) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tratamientos = tratamientos;
        this.medicamento = medicamento;
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamientos;
    }

    public void setTratamiento(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

}
