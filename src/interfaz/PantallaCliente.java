package interfaz;

import java.util.Iterator;

import javax.swing.JOptionPane;

import logica.Cliente;
import logica.DatosProducto;
import logica.Envio;
import logica.HistorialEnvio;
import logica.InicioSesion;
import logica.Producto;

public class PantallaCliente implements InicioSesion, DatosProducto{

	public void MenuCliente(Cliente cliente, HistorialEnvio envio) {
	

		PantallaCliente pc = new PantallaCliente();
		
		String[] opCliente = {"Solicitar envio","Ver informacion envios", "Salir"};
		
		int opciones;
		do {
			opciones=JOptionPane.showOptionDialog(null,"Ingrese la opcion", null, 0, 0, null, opCliente, opCliente[0]);
		
	
			 boolean fragil;
			 String fragilidad = "fragil+";
		        String nombre = "";
		        double peso = 0;
		        String tamaño;
		        boolean ver = false;

		     
		        if (opciones==0) {
					
		            
		                nombre = JOptionPane.showInputDialog("Ingrese nombre del producto:");
		                if (pc.nombrePorducto(nombre)==false) {
		                	
	                		System.out.println("ENTRE AL FALSE");


		                } else {
		                    
		                	try {
								
		                	peso = Double.parseDouble( "Ingrese el peso del producto");
		                	if (pc.pesoProducto(peso)==false) {
		                		
		                		System.out.println("ENTRE AL FALSE");

		                	} else {
		                		
		                		
		                		String[] op = { "Sí", "No" };
		                		
		                		int seleccion = JOptionPane.showOptionDialog(null, "¿Es este producto frágil?", "Pregunta",
		                				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
		                		
		                		fragil = (seleccion == JOptionPane.YES_OPTION);
		                		
		                		
		                		Producto productoNuevo = new Producto(nombre, fragilidad ,peso);            
		                		
		                		cliente.solicitarEnvio(productoNuevo);
		                	}
		                	} catch (Exception e) {
		                		// TODO: handle exception
		                	}
		                }
		            
		  

		        }else if (opciones==1) {
					
		        	JOptionPane.showMessageDialog(null, "Informacion de los envios: ");
				}

		} while (opciones!=2);
		
		
	}
	
}
