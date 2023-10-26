package logica;

import java.util.LinkedList;

public class Capitan extends Persona {
	private int idCapitan;
	private LinkedList <Capitan> capitanes = new LinkedList <>();
	
	public Capitan(String nombre, String apellido, String mail, String clave, String rol, int idCapitan) {
		super(nombre, apellido, mail, clave);
		this.idCapitan = idCapitan;
		this.capitanes = capitanes;
	}
	public int getIdCapitan() {
		return idCapitan;
	}
	public void setIdCapitan(int idCapitan) {
		this.idCapitan = idCapitan;
	}
	public LinkedList<Capitan> getCapitanes() {
		return capitanes;
	}
	public void setCapitanes(LinkedList<Capitan> capitanes) {
		this.capitanes = capitanes;
	}
	@Override
	public String toString() {
		return "Capitan [idCapitan=" + idCapitan + ", capitanes=" + capitanes + "]";
	}

	/*
	public void agregar () {
		Capitan capitan1 = new Capitan ("", "", "", "", "", 0);
		capitanes.add(capitan1);
		
	}
	*/
}
