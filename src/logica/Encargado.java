package logica;
import javax.swing.JOptionPane;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;


public class Encargado extends Persona{
	private int idEncargado;
	private static final AtomicInteger indice = new AtomicInteger(0);

	private LinkedList <Encargado> encargados = new LinkedList <>();

	
	
		
	public Encargado(String nombre, String apellido, String mail, String clave, String rol, int idEncargado) {
		super(nombre, apellido, mail, clave, rol);
		this.idEncargado = idEncargado;
		this.encargados = encargados;
	}



	public int getIdEncargado() {
		return idEncargado;
	}




	public void setIdEncargado(int idEncargado) {
		this.idEncargado = idEncargado;
	}


	public LinkedList<Encargado> getEncargados() {
		return encargados;
	}



	public void setEncargados(LinkedList<Encargado> encargados) {
		this.encargados = encargados;
	}




	public static AtomicInteger getIndice() {
		return indice;
	}


	@Override
	public String toString() {
		return "Encargado [idEncargado=" + idEncargado + ", encargados=" + encargados + "]";
	}

	
	/*
	public void agregar () {
		Encargado encargado3 = new Encargado("juan", "Perez", "ivanbilkis", "123456789", "Encargado", 1);
		Encargado encargado2 = new Encargado("pedro", "Perez", "pedroperez", "123456789", "Encargado", 1);
		Encargado encargado1 = new Encargado("Horacio", "Perez", "juanperez", "123456789", "Encargado", 1);
		encargados.add(encargado1);
		encargados.add(encargado2);
		encargados.add(encargado3);

		
	}
	*/
	
	public double calcularRutaMaritima(Barco barco) {
		return 0;
	}
	
}
