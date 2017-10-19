package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Notificacion {
	private final StringProperty codNotificacion;
	private final StringProperty direccion;
	private final StringProperty urgencia;
	private final StringProperty tipo;

	public Notificacion(String codNotificacion, String direccion, String urgencia, String tipo) {
		this.codNotificacion = new SimpleStringProperty(codNotificacion);
		this.direccion = new SimpleStringProperty(direccion);
		this.urgencia = new SimpleStringProperty(urgencia);
		this.tipo = new SimpleStringProperty(tipo);
	}

	public String getCodNotificacion() {
		return codNotificacion.get();
	}

	public void setCodNotificacion(String codNotificacion) {
		this.codNotificacion.set(codNotificacion);
	}

	public StringProperty codNotificacionProperty() {
		return codNotificacion;
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

	public String getUrgencia() {
		return urgencia.get();
	}

	public void setUrgencia(String urgencia) {
		this.urgencia.set(urgencia);
	}

	public StringProperty urgenciaProperty() {
		return urgencia;
	}

	public String getTipo() {
		return tipo.get();
	}

	public void setTipo(String tipo) {
		this.tipo.set(tipo);
	}

	public StringProperty tipoProperty() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Notificacion [codNotificacion=" + codNotificacion + ", direccion=" + direccion + ", urgencia="
				+ urgencia + ", tipo=" + tipo + "]";
	}

}
