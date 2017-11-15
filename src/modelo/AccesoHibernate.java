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

	public void cargarTodo() {
		obtenerLugar();
		obtenerNotificacion();
		obtenerEmpleado();

	}

	public HashMap<Integer, Empleado> obtenerEmpleado() {
		Query q = session.createQuery("select dep from Empleado dep");
		List results = q.list();
		int clave;
		HashMap<Integer, Empleado> depositosCreados = new HashMap<Integer, Empleado>();
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Empleado team = (Empleado) equiposIterator.next();

			depositosCreados.put(team.getCodInterno(), team);

		}

		return depositosCreados;
	}

	public HashMap<Integer, Lugar> obtenerLugar() {
		Query q = session.createQuery("select dis from Lugar dis");
		List results = q.list();
		String clave;
		HashMap<Integer, Lugar> dispensadorCreados = new HashMap<Integer, Lugar>();
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Lugar team = (Lugar) equiposIterator.next();
			// team = new Dispensador(team.getClave(), team.getNombreProducto(),
			// team.getPrecio(), team.getCantidad());
			// clave = team.getClave();
			dispensadorCreados.put(team.getCodParque(), team);

		}
		return dispensadorCreados;
	}

	public HashMap<Integer, Notificacion> obtenerNotificacion() {
		Query q = session.createQuery("select dis from Notificacion dis");
		List results = q.list();
		String clave;
		HashMap<Integer, Notificacion> dispensadorCreados = new HashMap<Integer, Notificacion>();
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Notificacion team = (Notificacion) equiposIterator.next();
			// team = new Dispensador(team.getClave(), team.getNombreProducto(),
			// team.getPrecio(), team.getCantidad());
			// clave = team.getClave();
			dispensadorCreados.put(team.getCodNotificacion(), team);

		}
		return dispensadorCreados;
	}

	public void guardarEmpleados(Empleado empleados) {
		session.save(empleados);
	}

	public void guardarLugar(Lugar ar) {
		
		session.save(ar);
	}

	public void guardarNotificacion(Notificacion notificacion) {
		session.save(notificacion);

	}
}
