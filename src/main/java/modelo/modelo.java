package modelo;

import java.util.ArrayList;
import java.util.List;
import pacientes.Paciente;

/**
 *
 * @author zakaria Abouhammadi
 */

public final class modelo {
    
    
    private List<Paciente> pacientes;
    /*
    * Nombre del Usuario.
    */
    private String nombreUsuario;
    
    /*
    * Contrasña del Usuario.
    */
    private String contrasenyaUsuario;
    
    
    public modelo() {
        this.pacientes = new ArrayList<>();
    }
    
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    /**
    * Obtiene el nombre del usuario.
    * @return  Nombre Del usuario.
    */
    public String getnombreUsuario() {
        return nombreUsuario;
    }
    
    /**
    * Obtiene la contraseña del usuario.
    * @return  Contraseña del usuario.
    */
    public String getContrasenyaUsuario() {
        return contrasenyaUsuario;
    }
    
    /**
    * Determina el tipo de usuario basado en el nombre de usuario y la contraseña proporcionados.
    *
    * @param nombreUsuario el nombre de usuario proporcionado
    * @param contrasenyaUsuario la contraseña proporcionada
    * @return el tipo de usuario correspondiente ("medico", "enfermera","desconocido")
    */
    public String tipoDeUsuario(String nombreUsuario, String contrasenyaUsuario) {     
        if (nombreUsuario.equals("medico") && contrasenyaUsuario.equals("medico")) {
            return "medico";
        } else if (nombreUsuario.equals("enfermera") && contrasenyaUsuario.equals("enfermera")) {
            return "cliente";
        } else {
            return "desconocido";
        }
    }
    
    public Paciente getPacientePorNombre(String nombre) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNombre().equalsIgnoreCase(nombre)) {  
                
                return paciente;
            }
        }
        
    return null;
    }
    
    public void agregarPaciente(List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            this.pacientes.add(paciente);
        }
    }
    //COSAS DEL MODELO QUE SI TENEMOS IDEA DE QUE SON
    
    
    
    
}
