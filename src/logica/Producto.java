package logica;

public class Producto {
	private int idProducto;
	private String nombre;
	private int peso;
	private String tamaño;
	private String fragil;
	
	
	public Producto(String nombre, String fragil,int peso) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.fragil = fragil;
		this.peso = peso;
		this.tamaño = tamaño;
	
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", peso=" + peso + ", tamaño=" + tamaño
				+ ", fragil=" + fragil + "]";
	}


	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getFragil() {
		return fragil;
	}
	public void setFragil(String fragil) {
		this.fragil = fragil;
	}
}

