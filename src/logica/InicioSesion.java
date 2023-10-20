package logica;

import javax.swing.JOptionPane;

public interface InicioSesion {
	
	public default  boolean iniciarSesionNombre(String nombre) {
		
		if (nombre.isEmpty() || nombre.length() <= 2) {
			
			JOptionPane.showMessageDialog(null, "Error en el usuario, vuelva a ingresarlo");
			return false;
		}else {
			
			return true;
		}
		
	}
	
	 /**/
	
	public default  boolean iniciarSesionClave(String clave, String claverepetida) {
	
		if (clave.isEmpty() || clave.length() < 8) {
			if (claverepetida.isEmpty() || claverepetida.length() <8 || clave != claverepetida) {
				
				JOptionPane.showMessageDialog(null, "Error en la clave, vuelva a ingresarlo");
			
			}
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
