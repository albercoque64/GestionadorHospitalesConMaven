package medico;
/**
 *
 * @author Zakaria
 */

import enfermedades.Enfermedad;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Buscar_EnfermedadesVistaTest {

    private Buscar_EnfermedadesVista instance;

    @BeforeEach
    public void setUp() {
        instance = new Buscar_EnfermedadesVista();
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetEnfermedades() {
        List<Enfermedad> enfermedades = new ArrayList<>();
        enfermedades.add(new Enfermedad("Gripe", "Infección viral", "Reposo", "Paracetamol", "500mg"));
        enfermedades.add(new Enfermedad("Diabetes", "Condición crónica", "Control de azúcar", "Insulina", "10U"));

        instance.getEnfermdedades(enfermedades);

        List<Enfermedad> enfermedadesInternas = instance.getEnfermedadesInternas();

        assertNotNull(enfermedadesInternas, "La lista de enfermedades internas no debe ser nula.");
        assertEquals(2, enfermedadesInternas.size(), "La lista de enfermedades internas debe tener 2 elementos.");
        assertEquals("Gripe", enfermedadesInternas.get(0).getNombre(), "El primer elemento debe ser Gripe.");
        assertEquals("Diabetes", enfermedadesInternas.get(1).getNombre(), "El segundo elemento debe ser Diabetes.");
    }

    @Test
    public void testActualizarLista() {
        List<Enfermedad> enfermedades = new ArrayList<>();
        enfermedades.add(new Enfermedad("Gripe", "Infección viral", "Reposo", "Paracetamol", "500mg"));
        enfermedades.add(new Enfermedad("Diabetes", "Condición crónica", "Control de azúcar", "Insulina", "10U"));
        enfermedades.add(new Enfermedad("Resfriado", "Infección viral leve", "Líquidos y reposo", "Ibuprofeno", "400mg"));

        instance.getEnfermdedades(enfermedades);

        // Llamar al método de actualización de lista
        instance.actualizarLista("gri");

        assertEquals(1, instance.getListaEnfermedades().getModel().getSize(), "La lista de enfermedades debe tener solo un elemento.");
        assertEquals("Gripe", instance.getListaEnfermedades().getModel().getElementAt(0), "El elemento debe ser 'Gripe'.");
    }
}
