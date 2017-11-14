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
			depositosCreados.put(team.getValor(), team);
			System.out.println("		Id: " + team.getId() + " - NombreMoneda: " + team.getNombreMoneda()
					+ " - Valor: " + team.getValor() + " - Cantidad: " + team.getCantidad());
		}

		System.out.println("Fin Consulta Deposito");
		return depositosCreados;
	}

	@Override
	public HashMap<String, Lugar> obtenerLugar() {
		Query q = session.createQuery("select dis from Dispensador dis");
		List results = q.list();
		String clave;
		HashMap<String, Dispensador> dispensadorCreados = null;
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Dispensador team = (Dispensador) equiposIterator.next();
//			team = new Dispensador(team.getClave(), team.getNombreProducto(), team.getPrecio(), team.getCantidad());
//			clave = team.getClave();
			dispensadorCreados.put(team.getClave(), team);
			System.out.println("		Id: " + team.getId() + " - Clave: " + team.getClave() + " - NombreProducto: "
					+ team.getNombreProducto() + " - Cantidad: " + team.getCantidad() + " - Precio: "
					+ team.getPrecio());

		}
		System.out.println("Fin Consulta Deposito");
		return dispensadorCreados;
	}
	
	@Override
	public HashMap<String, Notificacion> obtenerNotificacion() {
		Query q = session.createQuery("select dis from Dispensador dis");
		List results = q.list();
		String clave;
		HashMap<String, Dispensador> dispensadorCreados = null;
		Iterator equiposIterator = results.iterator();

		while (equiposIterator.hasNext()) {
			Dispensador team = (Dispensador) equiposIterator.next();
//			team = new Dispensador(team.getClave(), team.getNombreProducto(), team.getPrecio(), team.getCantidad());
//			clave = team.getClave();
			dispensadorCreados.put(team.getClave(), team);
			System.out.println("		Id: " + team.getId() + " - Clave: " + team.getClave() + " - NombreProducto: "
					+ team.getNombreProducto() + " - Cantidad: " + team.getCantidad() + " - Precio: "
					+ team.getPrecio());

		}
		System.out.println("Fin Consulta Deposito");
		return dispensadorCreados;
	}

	@Override
	public boolean guardarDepositos(HashMap<Integer, Deposito> depositos) {
		for (Integer key : depositos.keySet()) {
			Deposito deposito = (Deposito) depositos.get(key);
			session.update(deposito);
		}
		return true;
	}

	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		for (String key : dispensadores.keySet()) {
			Dispensador dispensador = (Dispensador) dispensadores.get(key);
			session.update(dispensador);
		}
		return true;
	}
	
	@Override
	public boolean guardarDispensadores(HashMap<String, Dispensador> dispensadores) {
		for (String key : dispensadores.keySet()) {
			Dispensador dispensador = (Dispensador) dispensadores.get(key);
			session.update(dispensador);
		}
		return true;
	}

}
