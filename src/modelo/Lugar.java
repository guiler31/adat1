package modelo;


public class Lugar {

	private final int codParque;
	private final String nombre;
	private final String telefono;
	private final String direccion;
	
	public Lugar(int codParque, String nombre, String telefono, String direccion) {
		this.codParque = codParque;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getCodParque() {
		return codParque;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Lugar [codParque=" + codParque + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

	

	
	
}
