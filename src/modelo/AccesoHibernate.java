package modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import modelo.HibernateUtil;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Notificacion;

public class AccesoHibernate {

	Session session;

	public AccesoHibernate() {

		HibernateUtil util = new HibernateUtil();
		session = util.getSessionFactory().openSession();
 
	}

	public HashMap<Integer, Empleado> obtenerEmpleado() {
		Query q = session.createQuery("select dep from Empleado dep");
		List results = q.list();
		int clave;
		HashMap<Integer, Empleado> depositosCreados = null;
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Empleado team = (Empleado) equiposIterator.next();
//			team = new Deposito(team.getNombreMoneda(), team.getValor(), team.getCantidad());
//			clave = team.getValor();
			depositosCreados.put(team.getCodInterno(), team);
			
		}

		System.out.println("Fin Consulta Deposito");
		return depositosCreados;
	}

	public HashMap<Integer, Lugar> obtenerLugar() {
		Query q = session.createQuery("select dis from Lugar dis");
		List results = q.list();
		String clave;
		HashMap<Integer, Lugar> dispensadorCreados = null;
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Lugar team = (Lugar) equiposIterator.next();
//			team = new Dispensador(team.getClave(), team.getNombreProducto(), team.getPrecio(), team.getCantidad());
//			clave = team.getClave();
			dispensadorCreados.put(team.getCodParque(), team);

		}
		System.out.println("Fin Consulta Deposito");
		return dispensadorCreados;
	}
	
	public HashMap<Integer, Notificacion> obtenerNotificacion() {
		Query q = session.createQuery("select dis from Notificacion dis");
		List results = q.list();
		String clave;
		HashMap<Integer, Notificacion> dispensadorCreados = null;
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Notificacion team = (Notificacion) equiposIterator.next();
//			team = new Dispensador(team.getClave(), team.getNombreProducto(), team.getPrecio(), team.getCantidad());
//			clave = team.getClave();
			dispensadorCreados.put(team.getCodNotificacion(), team);
			
		}
		System.out.println("Fin Consulta Deposito"+dispensadorCreados);
		return dispensadorCreados;
	}

	public boolean guardarEmpleados(HashMap<Integer, Empleado> empleados) {
		for (Integer key : empleados.keySet()) {
			Empleado deposito = (Empleado) empleados.get(key);
			session.update(deposito);
		}
		return true;
	}

	public boolean guardarLugares(HashMap<Integer, Lugar> lugares) {
		for (Integer key : lugares.keySet()) {
			Lugar dispensador = (Lugar) lugares.get(key);
			session.update(dispensador);
		}
		return true;
	}
	
	public boolean guardarNotificaciones(HashMap<Integer, Notificacion> notificaciones) {
		for (Integer key : notificaciones.keySet()) {
			Notificacion dispensador = (Notificacion) notificaciones.get(key);
			session.update(dispensador);
		}
		return true;
	}

}
