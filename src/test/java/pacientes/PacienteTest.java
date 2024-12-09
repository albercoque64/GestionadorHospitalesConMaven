package pacientes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import historial.HistorialMedico;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente("Juan", "Pérez", "Fiebre", 101, "Paracetamol", "500mg", "Cada 8 horas");
    }

    @Test
    public void testGetters() {
        assertEquals("Juan", paciente.getNombre());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("Fiebre", paciente.getSintomas());
        assertEquals("Paracetamol", paciente.getMedicamento());
        assertEquals("500mg", paciente.getDosis());
        assertEquals("Cada 8 horas", paciente.getFrecuencia());
        assertEquals(101, paciente.getHabitacion());
    }
    
    @Test
    public void testSetters() {
        paciente.setNombre("Carlos");
        assertEquals("Carlos", paciente.getNombre());
        paciente.setApellidos("Gómez");
        assertEquals("Gómez", paciente.getApellidos());
        paciente.setSintomas("Dolor de cabeza");
        assertEquals("Dolor de cabeza", paciente.getSintomas());
        paciente.setMedicamento("Ibuprofeno");
        assertEquals("Ibuprofeno", paciente.getMedicamento());
        paciente.setDosis("200mg");
        assertEquals("200mg", paciente.getDosis());
        paciente.setFrecuencia("Cada 6 horas");
        assertEquals("Cada 6 horas", paciente.getFrecuencia());
        paciente.setHabitacion(102);
        assertEquals(102, paciente.getHabitacion());
    }

    @Test
    public void testHistorialMedico() {
        HistorialMedico historial = new HistorialMedico();
        paciente.setHistorialMedico(historial);
        assertEquals(historial, paciente.getHistorialMedico());
    }
}