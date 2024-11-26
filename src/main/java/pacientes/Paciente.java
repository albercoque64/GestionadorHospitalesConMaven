package pacientes;

import historial.HistorialMedico;

/**
 *
 * @author Albercoque64
 */
public class Paciente {

    private String nombre;
    private String apellidos;
    private String sintomas;
    private String medicamento;
    private String dosis;
    private String frecuencia;
    private int habitacion;
    private HistorialMedico historialMedico;
    
    public Paciente(String nombre, String apellidos, String sintomas, int habitacion, String medicamento, String dosis, String frecuencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sintomas = sintomas;
        this.habitacion = habitacion;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }
    
    public String getNombre() {

        return nombre;
    }

    public String getApellidos() {

        return apellidos;
    }

    public String getSintomas() {

        return sintomas;
    }

    public String getMedicamento() {

        return medicamento;
    }

    public String getDosis() {

        return dosis;
    }

    public String getFrecuencia() {

        return frecuencia;
    }

    public int getHabitacion() {

        return habitacion;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {

        this.apellidos = apellidos;
    }

    public void setSintomas(String sintomas) {

        this.sintomas = sintomas;
    }

    public void setMedicamento(String medicamento) {

        this.medicamento = medicamento;
    }

    public void setDosis(String dosis) {

        this.dosis = dosis;
    }

    public void setFrecuencia(String frecuencia) {

        this.frecuencia = frecuencia;
    }

    public void setHabitacion(int habitacion) {

        this.habitacion = habitacion;
    }
    
    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }
}
