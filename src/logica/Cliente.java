package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Conexion;
import interfaz.PantallaCliente;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente extends Persona {
	
	
	private static final AtomicInteger indice = new AtomicInteger(0);
	
	private int idCliente;
	private LinkedList <Cliente> clientes = new LinkedList <>();
	

	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
	}



	public Cliente(String nombre, String apellido, String mail, String clave) {
		super(nombre, apellido, mail, clave);
		this.idCliente = idCliente;
		this.clientes = clientes;
		
		
	}
	String h;
	@Override
	public String toString() {
		/*StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.getClientes().size(); i++) {
			
			 sb.append("Cliente" +this.getClientes().get(i).getIdCliente() +": Nombre:" + this.getClientes().get(i).getNombre()+ 
					 " Apellido:"+ this.getClientes().get(i).getApellido() +" Nombre de usuario:" + this.getClientes().get(i).getMail() +"\n");
		}
		return sb.toString();
	*/
		//porque estan las variables desacomocdadas?
		
		return "Cliente:"+ " [Id:" + this.getNombre()+ " Nombre:"+ this.getApellido() +" Apellido:" + this.getMail() + " Nombre de usuario:" +this.getClave() +"]\n";
	} 
	
	HistorialEnvio he = new HistorialEnvio (0, null);
	Producto pr = new Producto (0, null, 0, null, null);
	
	Conexion conexion = new Conexion ();
	Connection con = conexion.conectar(); 
	PreparedStatement stmt;
	
	
	public boolean inicioSsesionCliente () {
		Encargado encar = new Encargado ("", "", "", "", "", 1);
		PantallaCliente p= new PantallaCliente ();
		
		String sql = "SELECT * FROM `cliente` WHERE usuario=? AND clave=?";

		try {
		    stmt = con.prepareStatement(sql);
		    stmt.setString(1, this.getMail());
		    stmt.setString(2, this.getClave());
		    
		    
		    ResultSet resultados = stmt.executeQuery();


		    if (resultados.next()==true) {
		    	p.MenuCliente(this, he, pr);

		        return true;
		        
		    } else {
		        return false;
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error en el inicio de sesión");
		    return false;
		}

		
			
		}
		
		
	
	
	public boolean guardar () {
		
		String sql = "INSERT INTO `cliente`( `nombre`, `apellido`, `usuario`, `clave`)  VALUES (?,?,?,?)";
		
		System.out.println(sql);
		System.out.println(stmt);
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setString(4, this.getClave());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}
	
	 public boolean solicitarEnvio(LinkedList <Envio> envios , Producto producto) {
		   boolean ver = false;
		   boolean fragil;
		   String nombre="";
		   int peso=0;
		   String tamaño;

		   do {
		       try {
		           nombre = JOptionPane.showInputDialog("Ingresar nombre del producto");
		           if (nombre.isEmpty()) {
		               JOptionPane.showMessageDialog(null, "Nombre no ingresado correctamente");
		           } else {
		               JOptionPane.showMessageDialog(null, "Nombre ingresado correctamente");
		               ver = true;
		               producto.setNombre(nombre);
		           }
		       } catch (NullPointerException e) {
		           JOptionPane.showMessageDialog(null, "Error: No se proporcionó un nombre.");
		       }
		   } while (!ver);

		   ver = false;

		   do {
		       try {
		           peso =  Integer.parseInt(JOptionPane.showInputDialog("Ingresar peso del producto"));
		           if (peso < 1) {
		               JOptionPane.showMessageDialog(null, "Peso no ingresado correctamente");
		           } else {
		               JOptionPane.showMessageDialog(null, "Peso ingresado correctamente");
		               ver = true;
		               producto.setPeso(peso);
		           }
		       } catch (NumberFormatException e) {
		           JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido para el peso.");
		       }
		   } while (!ver);

		   do {
		      tamaño=JOptionPane.showInputDialog("ingresar tamaño del producto");
		       if (tamaño.isEmpty()) {
		           JOptionPane.showMessageDialog(null, "Tamaño no ingresada correctamente");
		       } else {
		           JOptionPane.showMessageDialog(null, "Tamaño ingresada correctamente");
		           producto.setTamaño(tamaño);
		           ver = true;
		       }
		   } while (!ver);

		   String[] opciones = {"Sí", "No"};

		   int seleccion = JOptionPane.showOptionDialog(null, "¿Es este producto frágil?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
		           null, opciones, opciones[0]);

		   fragil = (seleccion == JOptionPane.YES_OPTION);

		 
		   String sql = "INSERT INTO `producto `(`nombre_producto`, `fragilidad`, `peso`, `id_divisa`) VALUES (?,?,?,?)";


		try {
		stmt = con.prepareStatement(sql);
		stmt.setString(1, producto.getNombre());
		stmt.setString(2, producto.getFragil());
		stmt.setLong(3, producto.getPeso());
		stmt.setInt(4, 1);
		System.out.println(sql);
		System.out.println(stmt);
		stmt.execute();
		return true;
		} catch (Exception e) {
		return false;
		}


		   
		   
		   
		 
		}



	
	public void infoEnvio(LinkedList<Envio> envios) {
		if (envios.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay envios para mostrar");
		}
		for (Envio envio : envios) {
			JOptionPane.showMessageDialog(null, envios +"\n");
		}
		
	}

	
	
}
