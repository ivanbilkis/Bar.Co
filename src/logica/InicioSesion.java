package logica;

import javax.swing.JOptionPane;

public interface InicioSesion {
	
	public default  boolean iniciarSesionNombre(String nombre, Cliente cliente) {
		
		if (nombre.isEmpty() || nombre.length() <= 2) {
			
			JOptionPane.showMessageDialog(null, "Error en el usuario, vuelva a ingresarlo");
			return false;
		}else {
			
			return true;
		}
		
	}
	
	 /**/
	
	public default  boolean iniciarSesionClave(String clave, String claverepetida) {
	
<<<<<<< Updated upstream
		if (clave.isEmpty() || claverepetida.isEmpty() || clave != claverepetida  || clave.length() < 8 || claverepetida.length() <8) {
			JOptionPane.showMessageDialog(null, "Error en la clave, vuelva a ingresarlo");
=======
		if (clave.isEmpty() || clave.length() < 2 ) {
			if (claverepetida.isEmpty() || claverepetida.length() <2 || clave != claverepetida) {
				
				JOptionPane.showMessageDialog(null, "Error en la clave, vuelva a ingresarlo");
			
			}
			return false;
>>>>>>> Stashed changes

			return false;
		}else {
			
			return true;
		}
	
	
	
	}
	public default boolean validarMail (String nombre) {
		
		if (nombre.contains("@") && nombre.contains(".com")) {
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Error en el usuario, vuelva a ingresarlo");
			return false;
		}
		
	}

}
