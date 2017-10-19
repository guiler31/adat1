package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lugar {

	private final StringProperty codParque;
	private final StringProperty nombre;
	private final StringProperty telefono;
	private final StringProperty direccion;

	public Lugar(String codParque, String nombre, String telefono, String direccion) {
		this.codParque = new SimpleStringProperty(codParque);
		this.nombre = new SimpleStringProperty(nombre);
		this.telefono = new SimpleStringProperty(telefono);
		this.direccion = new SimpleStringProperty(direccion);
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

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public String getTelefono() {
		return telefono.get();
	}

	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}

	public StringProperty telefonoProperty() {
		return telefono;
	}

	public String getDireccion() {
		return direccion.get();
	}

	public void setDireccion(String direccion) {
		this.direccion.set(direccion);
	}

	public StringProperty direccionProperty() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Lugar [codParque=" + codParque + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

}
