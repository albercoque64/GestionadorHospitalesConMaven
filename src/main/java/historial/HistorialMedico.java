package historial;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {

    private List<VisitaMedica> visitas;

    public HistorialMedico() {
        this.visitas = new ArrayList<>();
    }

    public void agregarVisita(String fecha, String descripcion, String diagnostico) {
        visitas.add(new VisitaMedica(fecha, descripcion, diagnostico));
    }

    public List<VisitaMedica> getVisitas() {
        return visitas;
    }

 
}
