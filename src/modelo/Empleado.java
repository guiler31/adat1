package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empleado {
	private final int codInterno;
	private final String dni;
	private final String nombre;
	private final String fechaNacimiento;
	private final String apellidos;
	private final int codParque;
	
	public Empleado(int codInterno, String dni, String nombre,  String apellidos,String fechaNacimiento,
			int codParque) {
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
