package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empleado {
	private final StringProperty codInterno;
	private final StringProperty dni;
	private final StringProperty nombre;
	private final StringProperty fechaNacimiento;
	private final StringProperty apellidos;
	private final StringProperty codParque;


	public Empleado(String codInterno, String dni, String nombre, String apellidos, String fechaNacimiento, String codParque) {
		this.codInterno = new SimpleStringProperty(codInterno);
		this.dni = new SimpleStringProperty(dni);
		this.nombre = new SimpleStringProperty(nombre);
		this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
		this.apellidos = new SimpleStringProperty(apellidos);
		this.codParque = new SimpleStringProperty(codParque);


	}

	public String getCodInterno() {
		return codInterno.get();
	}

	public void setCodInterno(String codInterno) {
		this.codInterno.set(codInterno);
	}

	public StringProperty codInternoProperty() {
		return codInterno;
	}


	public String getCodParque() {
		return codParque.get();
	}

	public void setCodParque(String codParque) {
		this.codParque.set(codParque);
	}

	public StringProperty codParqueProperty() {
		return codParque;
	}

	
	public String getDni() {
		return dni.get();
	}

	public void setDni(String dni) {
		this.dni.set(dni);
	}

	public StringProperty dniProperty() {
		return dni;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public String getfechaNacimiento() {
		return fechaNacimiento.get();
	}

	public void setfechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento.set(fechaNacimiento);
	}

	public StringProperty fechaNacimientoProperty() {
		return fechaNacimiento;
	}

	public String getApellidos() {
		return codInterno.get();
	}

	public void setApellidos(String apellidos) {
		this.apellidos.set(apellidos);
	}

	public StringProperty apellidosProperty() {
		return apellidos;
	}

	@Override
	public String toString() {
		return "Empleado [codInterno=" + codInterno + ", dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", apellidos=" + apellidos + ", codParque=" + codParque + "]";
	}

	

}
