package historial;

public class VisitaMedica {
    private String fecha;
    private String descripcion;
    private String diagnostico;

    public VisitaMedica(String fecha, String descripcion, String diagnostico) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public String toString() {
        return fecha + " - " + descripcion + " - " + diagnostico;
    }
}
