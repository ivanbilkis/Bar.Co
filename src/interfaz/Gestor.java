package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import datos.Conexion;
import logica.Capitan;
import logica.Cliente;
import logica.Encargado;
import logica.Envio;
import logica.HistorialEnvio;
import logica.InicioSesion;
import logica.Producto;
import validacion.Validar;

public class Gestor implements InicioSesion {

	public static void main(String[] args) {
		Gestor valida = new Gestor();
		Validar va = new Validar ();
		Cliente cliente = new Cliente("", "", "", "");
		PantallaCliente pc = new PantallaCliente ();
		Encargado encargado = new Encargado ("", "", "", "", "", 0);
		PantallaEncargado pe = new PantallaEncargado ();
		Capitan capitan = new Capitan ("", "", "", "", "", 0);
		PantallaCapitan pca = new PantallaCapitan ();
		HistorialEnvio hist = new HistorialEnvio(0, null);
		//Producto prod = new Producto (0, null, 0, null, null);
		
		
		Cliente cliente1 = new Cliente ("", "", "ivanivan", "123456789");
		cliente.getClientes().add(cliente1);
		
		Encargado encargado1 = new Encargado("Horacio", "Perez", "juanperez", "123456789", "Encargado", 1);
		encargado.getEncargados().add(encargado1);
		
		Capitan capitan1 = new Capitan ("", "", "hola", "123456789", "", 0);
		capitan.getCapitanes().add(capitan1);
		
		
		String clave = "";
		String claveconfirmar="";
		String nombre="", apellido="",  usuario="";
		boolean usuariorepetido;
		
		int opciones2;
		
		// mostrar clientes que estan en la bd JOptionPane.showMessageDialog(null, encargado.MostrarClientes());	
		//pe.MenuEncargado(encargado);
		String[] menu = {"Registarse","Iniciar Sesion", "Salir"};
		do {
			opciones2=JOptionPane.showOptionDialog(null,"Ingrese la opcion", null, 0, 0, null, menu, menu[0]);
			
		
				
		if (opciones2 == 0) {
			
			do {
			nombre= JOptionPane.showInputDialog("Ingrese su nombre");
			apellido= JOptionPane.showInputDialog("Ingrese su apellido");
			usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario (el nombre de usuario es su mail)");
			
			cliente.setMail(usuario);
			/*
		    usuariorepetido = false;
		    for (int i = 0; i < cliente.getClientes().size(); i++) {
		        if (usuario.equalsIgnoreCase(cliente.getClientes().get(i).getMail())) {
		        	usuariorepetido = true;
		            break;
		        }
		        
		    }
		    */
		    if (encargado.sesionExistente(cliente)) {
				//JOptionPane.showMessageDialog(null, "Usuario repetido, ingrese otro nombre de usuario");
				
			}else {
				
				

			    if (valida.iniciarSesionNombre(nombre)==true && valida.validarMail(usuario)== true && valida.iniciarSesionApellido(apellido)== true) {
			    	
			        clave = JOptionPane.showInputDialog("Ingrese su contraseña (tiene que tener 8 dígitos o más)");
			        claveconfirmar = JOptionPane.showInputDialog("Repita su contraseña para confirmar");
	
			        
			        if (valida.iniciarSesionClave(clave, claveconfirmar)==true) {
					
			        	
			        	if (clave.equalsIgnoreCase(claveconfirmar) ) {
							Cliente nuevoCliente = encargado.crearCliente(nombre, apellido, usuario, clave);
							cliente.getClientes().add(nuevoCliente);

						//	JOptionPane.showMessageDialog(null, nuevoCliente);
							
							System.out.println(nuevoCliente.guardar());
							
							JOptionPane.showMessageDialog(null, "Registrado con éxito!");
							
					}
			        	
			        }
			    }
		    
			}
		        }while (valida.iniciarSesionNombre(nombre)==false && valida.validarMail(usuario)==false && valida.iniciarSesionClave(clave, claveconfirmar)==false);
		            
		        
		
			System.out.println(encargado.MostrarClientes());

			
		
					
			
		
		}else if (opciones2==1) {
			
			usuario=JOptionPane.showInputDialog("ingrese su nombre de usuario");
			clave=JOptionPane.showInputDialog("ingrese su clave");
			
			cliente.setMail(usuario);
			cliente.setClave(clave);
			
			if (valida.iniciarSesionClave(usuario, clave) && valida.validarMail(usuario)) {
				
				cliente.inicioSsesionCliente();
			}else {

				JOptionPane.showMessageDialog(null, "Sesion no existente");
			}
				/*
			for (int i = 0; i < cliente.getClientes().size(); i++) {
				if (usuario.equalsIgnoreCase(cliente.getClientes().get(i).getMail()) && clave.equalsIgnoreCase(cliente.getClientes().get(i).getClave())) {
					//pc.MenuCliente(cliente, hist, prod);
					//Cliente nuevoCliente = new Cliente ("ivan", "ffff", "ivanbilkis@gmail.com", "111");

			}
				
			}
			for (int j = 0; j < encargado.getEncargados().size() ; j++) {
				
				if (usuario.equalsIgnoreCase(encargado.getEncargados().get(j).getMail()) && clave.equalsIgnoreCase(encargado.getEncargados().get(j).getClave())) {
					pe.MenuEncargado(encargado);
				}
			}
			
			
			for (int h = 0; h < capitan.getCapitanes().size(); h++) {
				if (usuario.equalsIgnoreCase(capitan.getCapitanes().get(h).getMail() )&& clave.equalsIgnoreCase(capitan.getCapitanes().get(h).getClave())) {
					pca.MenuCapitan(capitan);
				}
			}
			*/
			
		}
			
		} while (opciones2!=2);
		

	}

}

