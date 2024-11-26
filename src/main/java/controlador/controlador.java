package controlador;

import enfermera.AdministrarMedicamentos;
import enfermera.Buscar_Medicamentos_Vista;
import modelo.modelo;
import vista_Principal.LoginVista;
import enfermera.EnfermeraVista;
import enfermera.Administrar_Medicamentos_Vista;
import historial.HistorialMedico;
import historial.VisitaMedica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import main.GestionadorHospitales;
import medico.Buscar_EnfermedadesVista;
import medico.MedicoVista;
import medico.Ver_PacientesVista;
import medico.VerHistorialPaciente;
import pacientes.Paciente;

/**
 *
 * @author Zakaria Abouhmmadi
 */
public class controlador {

    private modelo model;

    //LOGIN
    private LoginVista view;

    //ENFERMERA
    private AdministrarMedicamentos enfermeraAdministrarMedicamentos;
    private EnfermeraVista enfermeraVista;
    private Buscar_Medicamentos_Vista enfermeraBuscar;
    private Administrar_Medicamentos_Vista enfermeraAdministrar;

    //MEDICO
    private MedicoVista medicoVista;
    private Ver_PacientesVista medicoPacientes;
    private Buscar_EnfermedadesVista medicoBuscar;
    private VerHistorialPaciente historialVista;
    private HistorialMedico historialMedico;
    private VisitaMedica visitaMedica;
    private VerHistorialPaciente verHistorialPaciente;

    public controlador(modelo model, LoginVista view, EnfermeraVista enfermeraVista, AdministrarMedicamentos enfermeraAdministrarMedicamentos, Buscar_Medicamentos_Vista enfermeraBuscar, Administrar_Medicamentos_Vista enfermeraAdministrar,
            MedicoVista medicoVista, Ver_PacientesVista medicoPacientes, Buscar_EnfermedadesVista medicoBuscar, VerHistorialPaciente verHistorialPaciente) {

        this.model = model;
        this.view = view;
        this.enfermeraVista = enfermeraVista;
        this.enfermeraAdministrarMedicamentos = enfermeraAdministrarMedicamentos;
        this.enfermeraBuscar = enfermeraBuscar;
        this.enfermeraAdministrar = enfermeraAdministrar;
        this.medicoVista = medicoVista;
        this.medicoPacientes = medicoPacientes;
        this.medicoBuscar = medicoBuscar;
        this.verHistorialPaciente = verHistorialPaciente;      
     
        ControladorActionListener onlyModelActionListener = new ControladorActionListener();

        this.view.setActionListener(onlyModelActionListener);
        this.enfermeraVista.setActionListener(onlyModelActionListener);
        this.enfermeraBuscar.setActionListener(onlyModelActionListener);
        this.enfermeraAdministrar.setActionListener(onlyModelActionListener);
        this.medicoVista.setActionListener(onlyModelActionListener);
        this.medicoPacientes.setActionListener(onlyModelActionListener);
        this.medicoBuscar.setActionListener(onlyModelActionListener);
        this.enfermeraAdministrarMedicamentos.setActionListener(onlyModelActionListener);
        this.verHistorialPaciente.setActionListener(onlyModelActionListener);

        this.enfermeraAdministrarMedicamentos.setValueChangeListener(onlyModelActionListener);

        this.medicoPacientes.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = medicoPacientes.getTable().getSelectedRow();
                    if (selectedRow != -1) {

                        String nombrePaciente = (String) medicoPacientes.getTable().getValueAt(selectedRow, 0);
                        Paciente pacienteSeleccionado = model.getPacientePorNombre(nombrePaciente);

                        if (pacienteSeleccionado.getHistorialMedico() != null) {

                            // Crear la vista del historial                                      
                            verHistorialPaciente.setPacienteSeleccionado(pacienteSeleccionado);

                            verHistorialPaciente.actualizarTabla(pacienteSeleccionado.getHistorialMedico().getVisitas());
                            verHistorialPaciente.setLocationRelativeTo(null);
                            verHistorialPaciente.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(medicoPacientes,
                                    "El Paciente no tien historial Medico",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);

                            String fecha = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce la fecha de la visita (YYYY-MM-DD):");
                            String descripcion = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce la descripción de la visita:");
                            String diagnostico = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce el diagnóstico:");
                            // Visita duplicada
                            pacienteSeleccionado.getHistorialMedico().agregarVisita(fecha, descripcion, diagnostico);

                            boolean existe = false;
                            List<VisitaMedica> visitas = verHistorialPaciente.getPacienteSeleccionado().getHistorialMedico().getVisitas();
                            for (VisitaMedica visita : visitas) {
                                if (visita.getFecha().equals(fecha) && visita.getDescripcion().equals(descripcion) && visita.getDiagnostico().equals(diagnostico)) {
                                    existe = true;
                                    break;
                                }
                            }

                            // Campos vacios
                            if (fecha != null && descripcion != null && diagnostico != null && !fecha.isEmpty() && !descripcion.isEmpty() && !diagnostico.isEmpty()) {
                                if (!existe) {
                                    verHistorialPaciente.getPacienteSeleccionado().getHistorialMedico().agregarVisita(fecha, descripcion, diagnostico);
                                    verHistorialPaciente.actualizarTabla(visitas); // Actualiza la tabla con la nueva visita
                                } else {
                                    JOptionPane.showMessageDialog(verHistorialPaciente, "La visita ya existe en el historial.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(verHistorialPaciente, "¡Todos los campos deben estar completos!", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                }
            }
        });

    }

    class ControladorActionListener implements ActionListener, ListSelectionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String command = ae.getActionCommand();
            System.out.print(command);

            switch (command) {

                //LOGIN
                case "cerrar":
                    System.exit(0);
                    break;

                case "iniciar":

                    if (view.getUsuario().isEmpty() || view.getContraseña().isEmpty()) {
                        // Mostrar aviso si algún campo está vacío
                        JOptionPane.showMessageDialog(view, "Todos los campos deben estar llenos", "Aviso", JOptionPane.WARNING_MESSAGE);
                        return; // Salir del método si hay campos vacíos
                    } else if (view.getUsuario().equals("enfermera") && view.getContraseña().equals("enfermera")) {
                        // Si el usuario y la contraseña coinciden con "enfermera" y "enfermera", abre la ventana ventanaAdminVista

                        view.hide();
                        enfermeraVista.setLocationRelativeTo(null);
                        enfermeraVista.setVisible(true);

                    } else if (view.getUsuario().equals("medico") && view.getContraseña().equals("medico")) {
                        // Si el usuario y la contraseña coinciden con "enfermera" y "enfermera", abre la ventana ventanaAdminVista

                        view.hide();
                        medicoVista.setLocationRelativeTo(null);
                        medicoVista.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(view, "El nombre o la contraseña es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                //ENFERMERA   
                case "enfermeraInventario":
                    enfermeraVista.hide();
                    enfermeraAdministrar.setLocationRelativeTo(null);
                    enfermeraAdministrar.setVisible(true);
                    enfermeraAdministrar.verificarStock(main.GestionadorHospitales.getMedicamentos());
                    break;

                case "enfermeraAdministrar":
                    enfermeraVista.hide();
                    enfermeraAdministrarMedicamentos.setLista(GestionadorHospitales.getPacientes());
                    enfermeraAdministrarMedicamentos.setLocationRelativeTo(null);
                    enfermeraAdministrarMedicamentos.setVisible(true);

                    break;
                case "enfermeraAdministrarCerrar":

                    enfermeraAdministrarMedicamentos.hide();
                    enfermeraVista.setLocationRelativeTo(null);
                    enfermeraVista.setVisible(true);

                    break;

                case "enfermeraMedicamentosCerrar":
                    enfermeraAdministrar.hide();
                    enfermeraVista.setLocationRelativeTo(null);
                    enfermeraVista.setVisible(true);

                    break;

                case "enfermeraBuscar":
                    enfermeraVista.hide();
                    enfermeraBuscar.setLocationRelativeTo(null);
                    enfermeraBuscar.setVisible(true);

                    break;

                case "enfermeraBuscarTipo":
                    enfermeraBuscar.setLista(GestionadorHospitales.getMedicamentos(), enfermeraBuscar.getTipo());

                    break;

                case "enfermeraBuscarCerrar":
                    enfermeraBuscar.hide();
                    enfermeraVista.setLocationRelativeTo(null);
                    enfermeraVista.setVisible(true);

                    break;

                case "enfermeraCerrar":
                    enfermeraVista.hide();
                    view.setLocationRelativeTo(null);
                    view.setVisible(true);

                    break;

                //MEDICO
                case "medicoBuscar":
                    medicoVista.hide();
                    medicoBuscar.setLocationRelativeTo(null);
                    medicoBuscar.setVisible(true);

                    break;

                case "medicoBuscarCerrar":
                    medicoBuscar.hide();
                    medicoVista.setLocationRelativeTo(null);
                    medicoVista.setVisible(true);

                    break;
                case "medicoPacientes":
                    medicoPacientes.setLocationRelativeTo(null);
                    medicoPacientes.setVisible(true);
                    medicoVista.hide();

                    break;

                case "medicoPacientesCerrar":
                    medicoPacientes.hide();
                    medicoVista.setLocationRelativeTo(null);
                    medicoVista.setVisible(true);

                    break;

                case "medicoCerrar":
                    medicoVista.hide();
                    view.setLocationRelativeTo(null);
                    view.setVisible(true);

                    break;

                case "añadirVisita":
                    String fecha = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce la fecha de la visita (YYYY-MM-DD):");
                    String descripcion = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce la descripción de la visita:");
                    String diagnostico = JOptionPane.showInputDialog(verHistorialPaciente, "Introduce el diagnóstico:");

                    // Visita duplicada
                    boolean existe = false;
                    List<VisitaMedica> visitas = verHistorialPaciente.getPacienteSeleccionado().getHistorialMedico().getVisitas();
                    for (VisitaMedica visita : visitas) {
                        if (visita.getFecha().equals(fecha) && visita.getDescripcion().equals(descripcion) && visita.getDiagnostico().equals(diagnostico)) {
                            existe = true;
                            break;
                        }
                    }

                    // Campos vacios
                    if (fecha != null && descripcion != null && diagnostico != null && !fecha.isEmpty() && !descripcion.isEmpty() && !diagnostico.isEmpty()) {
                        if (!existe) {
                            verHistorialPaciente.getPacienteSeleccionado().getHistorialMedico().agregarVisita(fecha, descripcion, diagnostico);
                            verHistorialPaciente.actualizarTabla(visitas); // Actualiza la tabla con la nueva visita
                        } else {
                            JOptionPane.showMessageDialog(verHistorialPaciente, "La visita ya existe en el historial.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(verHistorialPaciente, "¡Todos los campos deben estar completos!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("lista");
            enfermeraAdministrarMedicamentos.setDescripcion(GestionadorHospitales.getPacientes(), enfermeraAdministrarMedicamentos.getPaciente());
        }

    }
}
