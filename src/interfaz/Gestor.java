package interfaz;

import javax.swing.JOptionPane;

import logica.Capitan;
import logica.Cliente;
import logica.Encargado;
import logica.InicioSesion;

public class Gestor implements InicioSesion {

	public static void main(String[] args) {
		Gestor valida = new Gestor();

		Cliente cliente = new Cliente("", "", "", "", "", 0);
		PantallaCliente pc = new PantallaCliente ();
		Encargado encargado = new Encargado ("", "", "", "", "", 0);
		PantallaEncargado pe = new PantallaEncargado ();
		Capitan capitan = new Capitan ("", "", "", "", "", 0);
		PantallaCapitan pca = new PantallaCapitan ();
		
		Cliente cliente1 = new Cliente ("", "", "ivanivan", "123456789", "", 0);
		cliente.getClientes().add(cliente1);
		
		
		Encargado encargado1 = new Encargado("Horacio", "Perez", "juanperez", "123456789", "Encargado", 1);
		encargado.getEncargados().add(encargado1);
		
		Capitan capitan1 = new Capitan ("", "", "hola", "123456789", "", 0);
		capitan.getCapitanes().add(capitan1);
		
		
		String clave = "";
		String claveconfirmar="";
		String nombre="";
		boolean nombrerepetido;
		
		int opciones2;
		String[] menu = {"Registarse","Iniciar Sesion", "Salir"};
		do {
			opciones2=JOptionPane.showOptionDialog(null,"Ingrese la opcion", null, 0, 0, null, menu, menu[0]);
			
		
			
				
		if (opciones2 == 0) {
			
			do {
			nombre = JOptionPane.showInputDialog("Ingrese su nombre de usuario (el nombre de usuario es su mail)");

		    nombrerepetido = false;
		    for (int i = 0; i < cliente.getClientes().size(); i++) {
		        if (nombre.equalsIgnoreCase(cliente.getClientes().get(i).getMail())) {
		            nombrerepetido = true;
		            break;
		        }
		        
		    }
		    if (nombrerepetido==true) {
				JOptionPane.showMessageDialog(null, "Usuario repetido, ingrese otro nombre de usuario");
			}else {
				
				
	
			    if (nombrerepetido==false && valida.iniciarSesionNombre(nombre)==true && valida.validarMail(nombre)== true) {
			    	
			        clave = JOptionPane.showInputDialog("Ingrese su contraseña (tiene que tener 8 dígitos o más)");
			        claveconfirmar = JOptionPane.showInputDialog("Repita su contraseña para confirmar");
	
			        if (valida.iniciarSesionClave(clave, claveconfirmar)==true) {
					
			        	if (clave==claveconfirmar) {
							
							Cliente nuevoCliente = new Cliente("", "", nombre, clave, "", 0);
							
							cliente.getClientes().add(nuevoCliente);
							JOptionPane.showMessageDialog(null, "Registrado con éxito!");
							JOptionPane.showMessageDialog(null, cliente.getClientes());
							
						}else {
								JOptionPane.showMessageDialog(null, "Error en la constraseña");
						}
			        	
			        }
			    }
		    
			}
		        }while (valida.iniciarSesionNombre(nombre)==false && valida.validarMail(nombre)==false && valida.iniciarSesionClave(clave, claveconfirmar)==false);
		            
		        
		
		
			
		
					
			
		
		}else if (opciones2==1) {
			
			nombre=JOptionPane.showInputDialog("ingrese su nombre de usuario");
			clave=JOptionPane.showInputDialog("ingrese su clave");
			
			if (valida.iniciarSesionNombre(nombre)==false) {
				
			
			}
			if (valida.iniciarSesionClave(clave, claveconfirmar)==false) {

			}
			
			
			for (int i = 0; i < cliente.getClientes().size(); i++) {
				if (nombre.equalsIgnoreCase(cliente.getClientes().get(i).getMail()) && clave.equalsIgnoreCase(cliente.getClientes().get(i).getClave())) {
					pc.MenuCliente(cliente);
					
			}
				
			}
			for (int j = 0; j < encargado.getEncargados().size() ; j++) {
				
				if (nombre.equalsIgnoreCase(encargado.getEncargados().get(j).getMail()) && clave.equalsIgnoreCase(encargado.getEncargados().get(j).getClave())) {
					pe.MenuEncargado(encargado);
				}
			}
			
			
			for (int h = 0; h < capitan.getCapitanes().size(); h++) {
				if (nombre.equalsIgnoreCase(capitan.getCapitanes().get(h).getMail() )&& clave.equalsIgnoreCase(capitan.getCapitanes().get(h).getClave())) {
					pca.MenuCapitan(capitan);
				}
			}
			
			
		}
			
		} while (opciones2!=2);
		

	}

}

