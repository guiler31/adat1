package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empleado {
	private int codInterno;
	private String dni;
	private String nombre;
	private String fechaNacimiento;
	private String apellidos;
	private int codParque;
	
	public Empleado(){
		
	}
	public Empleado(int codInterno, String dni, String nombre,  String apellidos,String fechaNacimiento,
			int codParque) {
		super();
		this.codInterno = codInterno;
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.apellidos = apellidos;
		this.codParque = codParque;
	}

	public int getCodInterno() {
		return codInterno;
	}

	public void setCodInterno(int codInterno) {
		this.codInterno = codInterno;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCodParque(int codParque) {
		this.codParque = codParque;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getCodParque() {
		return codParque;
	}

	@Override
	public String toString() {
		return "Empleado [codInterno=" + codInterno + ", dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", apellidos=" + apellidos + ", codParque=" + codParque + "]";
	}


	

}
