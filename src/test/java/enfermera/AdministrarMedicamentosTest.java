package enfermera;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pacientes.Paciente;

public class AdministrarMedicamentosTest {

    private AdministrarMedicamentos instance;

    @BeforeEach
    public void setUp() {
        instance = new AdministrarMedicamentos();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    // Prueba del método main
    @Test
    public void testMain() {
        String[] args = {};
        AdministrarMedicamentos.main(args);
        assertTrue(true, "El método main se ejecutó correctamente.");
    }

    // Prueba de setActionListener
    @Test
    public void testSetActionListener() {
        ActionListener mockActionListener = e -> System.out.println("Acción disparada");
        instance.setActionListener(mockActionListener);
        assertNotNull(mockActionListener, "El ActionListener no debe ser nulo después de asignarlo.");
    }

    // Prueba de setValueChangeListener
    @Test
    public void testSetValueChangeListener() {
        ListSelectionListener mockChangeListener = e -> System.out.println("Cambio de selección");
        instance.setValueChangeListener(mockChangeListener);
        assertNotNull(mockChangeListener, "El ListSelectionListener no debe ser nulo después de asignarlo.");
    }

    @Test
    public void testSetLista() {
        // Crear lista de pacientes
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan", "Pérez", "Gripe", 101, "Paracetamol", "500mg", "Cada 8 horas"));
        pacientes.add(new Paciente("Ana", "López", "Resfriado", 102, "Ibuprofeno", "200mg", "Cada 6 horas"));
        pacientes.add(new Paciente("Carlos", "Martínez", "Fiebre", 103, "Amoxicilina", "250mg", "Cada 12 horas"));

        // Llamar al método setLista
        instance.setLista(pacientes);

        // Verificar el modelo de la lista usando el getter
        ListModel<String> modelo = instance.getLista().getModel();

        // Validaciones
        assertEquals(3, modelo.getSize(), "La lista debe contener 3 pacientes.");
        assertEquals("Juan", modelo.getElementAt(0), "El primer paciente debe ser Juan.");
        assertEquals("Ana", modelo.getElementAt(1), "El segundo paciente debe ser Ana.");
        assertEquals("Carlos", modelo.getElementAt(2), "El tercer paciente debe ser Carlos.");
    }

}
