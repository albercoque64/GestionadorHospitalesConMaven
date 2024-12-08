/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pacientes.Paciente;

/**
 *
 * @author adcan
 */
public class modeloTest {
    
    private modelo modelo;
    
    public modeloTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        modelo = new modelo();
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Probar el caso donde el usuario y la contraseña son "medico"
    @Test
    public void testTipoDeUsuarioMedico() {    
        
        String resultado = modelo.tipoDeUsuario("medico", "medico");
        assertEquals("medico", resultado, "El usuario debería ser reconocido como médico.");
    }
    
    // Probar el caso donde el usuario y la contraseña son "enfermera"
    @Test
    public void testTipoDeUsuarioEnfermera() {
        
        String resultado = modelo.tipoDeUsuario("enfermera", "enfermera");
        assertEquals("cliente", resultado, "El usuario debería ser reconocido como cliente.");
    }
    
    // Probar con un nombre de usuario incorrecto
    @Test
    public void testTipoDeUsuarioDesconocidoNombreIncorrecto() {
                   
        String resultado = modelo.tipoDeUsuario("admin", "medico");
        assertEquals("desconocido", resultado, "El usuario debería ser desconocido con un nombre incorrecto.");
    }
    
    // Probar con una contraseña incorrecta
    @Test
    public void testTipoDeUsuarioDesconocidoPasswordIncorrecto() {

        String resultado = modelo.tipoDeUsuario("medico", "1234");
        assertEquals("desconocido", resultado, "El usuario debería ser desconocido con una contraseña incorrecta.");
    }
    
    // Probar con ambos campos incorrectos
    @Test
    public void testTipoDeUsuarioDesconocidoAmbosIncorrectos() {
      
        String resultado = modelo.tipoDeUsuario("admin", "1234");
        assertEquals("desconocido", resultado, "El usuario debería ser desconocido con ambos campos incorrectos.");
    }
    
    // Probar cuando el paciente existe
    @Test
    public void testGetPacientePorNombreExistente() {
        
        Paciente paciente1 = new Paciente("Juan", "Pérez", "Dolor de cabeza", 101, "Paracetamol", "500mg", "Cada 8 horas");
        Paciente paciente2 = new Paciente("Ana", "López", "Fiebre", 102, "Ibuprofeno", "200mg", "Cada 6 horas");
        modelo.agregarPaciente(Arrays.asList(paciente1, paciente2));

        Paciente resultado = modelo.getPacientePorNombre("Juan");
        assertNotNull(resultado, "El paciente no debería ser nulo.");
        assertEquals("Juan", resultado.getNombre(), "El nombre del paciente debería coincidir.");
    }
    
    // Probar cuando el paciente no existe
    @Test
    public void testGetPacientePorNombreNoExistente() {
        
        Paciente paciente1 = new Paciente("Juan", "Pérez", "Dolor de cabeza", 101, "Paracetamol", "500mg", "Cada 8 horas");
        modelo.agregarPaciente(Arrays.asList(paciente1));

        Paciente resultado = modelo.getPacientePorNombre("Pedro");
        assertNull(resultado, "El resultado debería ser nulo para un paciente no existente.");
    }
    
    // Probar cuando la lista de pacienes esta vacia
    @Test
    public void testGetPacientePorNombreListaVacia() {

        Paciente resultado = modelo.getPacientePorNombre("Juan");
        assertNull(resultado, "El resultado debería ser nulo si la lista está vacía.");
    }
    
    // Probar agregar pacientes a lista vacia
     @Test
    public void testAgregarPacientesListaVacia() {
        
        Paciente paciente1 = new Paciente("Juan", "Pérez", "Dolor de cabeza", 101, "Paracetamol", "500mg", "Cada 8 horas");
        Paciente paciente2 = new Paciente("Ana", "López", "Fiebre", 102, "Ibuprofeno", "200mg", "Cada 6 horas");

        List<Paciente> listaPacientes = List.of(paciente1, paciente2);

        modelo.agregarPaciente(listaPacientes);

        assertEquals(2, modelo.getPacientes().size(), "El modelo debería tener 2 pacientes.");
        assertTrue(modelo.getPacientes().contains(paciente1), "El modelo debería contener al paciente Juan.");
        assertTrue(modelo.getPacientes().contains(paciente2), "El modelo debería contener al paciente Ana.");
    }
    
    // Probar agregar pacientes a Lista existente
    @Test
    public void testAgregarPacientesAListaExistente() {
        
        Paciente paciente1 = new Paciente("Juan", "Pérez", "Dolor de cabeza", 101, "Paracetamol", "500mg", "Cada 8 horas");
        modelo.agregarPaciente(List.of(paciente1));

        Paciente paciente2 = new Paciente("Ana", "López", "Fiebre", 102, "Ibuprofeno", "200mg", "Cada 6 horas");
        Paciente paciente3 = new Paciente("Luis", "Martínez", "Gripe", 103, "Amoxicilina", "250mg", "Cada 12 horas");
        modelo.agregarPaciente(List.of(paciente2, paciente3));

        assertEquals(3, modelo.getPacientes().size(), "El modelo debería tener 3 pacientes.");
        assertTrue(modelo.getPacientes().contains(paciente1), "El modelo debería contener al paciente Juan.");
        assertTrue(modelo.getPacientes().contains(paciente2), "El modelo debería contener al paciente Ana.");
        assertTrue(modelo.getPacientes().contains(paciente3), "El modelo debería contener al paciente Luis.");
    }
}
