package modelo;


public class Notificacion {
	private int codNotificacion;
	private String direccion;
	private String urgencia;
	private String tipo;

	public Notificacion(){
		
	}
	
	
	public Notificacion(int codNotificacion, String direccion, String urgencia, String tipo) {
		this.codNotificacion = codNotificacion;
		this.direccion = direccion;
		this.urgencia = urgencia;
		this.tipo = tipo;
	}

	public int getCodNotificacion() {
		
		return codNotificacion;
	}

	public void setCodNotificacion(int codNotificacion) {
		this.codNotificacion = codNotificacion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
