package modelo;


public class Lugar {

	private int codParque;
	private String nombre;
	private String telefono;
	private String direccion;
	
	public Lugar(){
		
	}
	
	public Lugar(int codParque, String nombre, String telefono, String direccion) {
		this.codParque = codParque;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public void setCodParque(int codParque) {
		this.codParque = codParque;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
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
