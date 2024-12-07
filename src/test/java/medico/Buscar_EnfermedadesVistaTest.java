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
    
    /**
     * Método que se ejecuta antes de cada prueba. Se utiliza para inicializar la instancia de Buscar_EnfermedadesVista
     */
    @BeforeEach
    public void setUp() {
        instance = new Buscar_EnfermedadesVista();
    }
    
    /**
     * Método que se ejecuta después de cada prueba. Se utiliza para limpiar la instancia de la clase
     */
    @AfterEach
    public void tearDown() {
        instance = null; // Libera la instancia después de cada prueba
    }
    
    /**
     * Prueba del método getEnfermedades
     * Verifica que la lista de enfermedades se asigna correctamente a la instancia
     */
    @Test
    public void testGetEnfermedades() {
        // Crea una lista de enfermedades de prueba
        List<Enfermedad> enfermedades = new ArrayList<>();
        enfermedades.add(new Enfermedad("Gripe", "Infección viral", "Reposo", "Paracetamol", "500mg"));
        enfermedades.add(new Enfermedad("Diabetes", "Condición crónica", "Control de azúcar", "Insulina", "10U"));
        
        // Llama al método getEnfermdedades para asignar las enfermedades a la instancia
        instance.getEnfermdedades(enfermedades);
        
        List<Enfermedad> enfermedadesInternas = instance.getEnfermedadesInternas();
        
        // Verifica que la instancia no es nula después de asignar las enfermedades
        assertNotNull(enfermedadesInternas, "La lista de enfermedades internas no debe ser nula.");
        // Verifica que la lista de enfermedades contiene el número correcto de elementos
        assertEquals(2, enfermedadesInternas.size(), "La lista de enfermedades internas debe tener 2 elementos.");
        // Verifica que los nombres de las enfermedades coinciden con los esperados
        assertEquals("Gripe", enfermedadesInternas.get(0).getNombre(), "El primer elemento debe ser Gripe.");
        assertEquals("Diabetes", enfermedadesInternas.get(1).getNombre(), "El segundo elemento debe ser Diabetes.");
    }
    
    /**
     * Prueba del método actualizarLista.
     * Verifica que el método actualice correctamente la lista de enfermedades en la interfaz.
     */
    @Test
    public void testActualizarLista() {
        // Crea una lista de enfermedades de prueba
        List<Enfermedad> enfermedades = new ArrayList<>();
        enfermedades.add(new Enfermedad("Gripe", "Infección viral", "Reposo", "Paracetamol", "500mg"));
        enfermedades.add(new Enfermedad("Diabetes", "Condición crónica", "Control de azúcar", "Insulina", "10U"));
        enfermedades.add(new Enfermedad("Resfriado", "Infección viral leve", "Líquidos y reposo", "Ibuprofeno", "400mg"));
        
        // Asigna la lista de enfermedades a la instancia de la vista
        instance.getEnfermdedades(enfermedades);

         // Llama al método actualizarLista para actualizar el modelo de la lista de enfermedades
        instance.actualizarLista("gri");
         // Verifica que la lista de enfermedades se actualice correctamente para incluir solo las enfermedades que coinciden con el término de búsqueda
        assertEquals(1, instance.getListaEnfermedades().getModel().getSize(), "La lista de enfermedades debe tener solo un elemento.");
        assertEquals("Gripe", instance.getListaEnfermedades().getModel().getElementAt(0), "El elemento debe ser 'Gripe'.");
    }
}
