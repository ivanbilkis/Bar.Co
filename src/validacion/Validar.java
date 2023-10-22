package validacion;
import javax.swing.JOptionPane;

import interfaz.Gestor;
import logica.Capitan;
import logica.Cliente;
import logica.Encargado;
import logica.InicioSesion;

public class Validar implements InicioSesion {

	Gestor validarinter = new Gestor ();
	
	
	public boolean validarIngreso (Cliente cliente) {
		
		
			return cliente.guardar();
		
	}
}
