package modelo;


public class Notificacion {
	private final int codNotificacion;
	private final String direccion;
	private final String urgencia;
	private final String tipo;

	public Notificacion(int codNotificacion, String direccion, String urgencia, String tipo) {
		this.codNotificacion = codNotificacion;
		this.direccion = direccion;
		this.urgencia = urgencia;
		this.tipo = tipo;
	}

	public int getCodNotificacion() {
		
		return codNotificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Notificacion [codNotificacion=" + codNotificacion + ", direccion=" + direccion + ", urgencia="
				+ urgencia + ", tipo=" + tipo + "]";
	}

	

}
