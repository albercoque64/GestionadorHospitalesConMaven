package medico;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicoVistaTest {

    private MedicoVista medicoVista;
    private boolean actionPerformedFlag;

    @BeforeEach
    public void setUp() {
        medicoVista = new MedicoVista();
        actionPerformedFlag = false;
        medicoVista.getBuscarEnfermedadesButton().addActionListener((ActionEvent e) -> {
            actionPerformedFlag = true;
        });
    }

    @Test
    public void testActionCommands() {
        assertEquals("medicoBuscar", medicoVista.getBuscarEnfermedadesButton().getActionCommand());
        assertEquals("medicoCerrar", medicoVista.getCerrarButton().getActionCommand());
        assertEquals("medicoPacientes", medicoVista.getVerPacientesButton().getActionCommand());
    }

    @Test
    public void testActionListener() {
        ActionListener[] listeners = medicoVista.getBuscarEnfermedadesButton().getActionListeners();
        assertNotNull(listeners);
        assertEquals(1, listeners.length);
        ActionEvent event = new ActionEvent(medicoVista.getBuscarEnfermedadesButton(), ActionEvent.ACTION_PERFORMED, "medicoBuscar");
        listeners[0].actionPerformed(event);
        assertTrue(actionPerformedFlag);
    }
}
