package modelo;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Notificacion;
import modelo.Modelo; 




public class Modelo {
	private String database = "proteccioncivil";
	private String user = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" 
	+ database;
	private Connection connect;
	private Empleado empleado;
	private Lugar lugar;
	private Notificacion notificacion;
	private String [][] ArraydatosEmpleado;
	private String [][] ArraydatosLugar;
	private String [][] ArraydatosNotificacion;
	private ObservableList<Empleado> masterDatas;
	private ObservableList<Notificacion> masterDatas2;
	private ObservableList<Lugar> masterDatas3;

	public Modelo(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url,user,pwd);
			cargarDatosTablas();
			
		}
		catch(Exception e){
			System.out.println("Could not connect with database");
			e.printStackTrace();
		}
	}
	


	public void DataEmpl() {
		try {
			
			String query = "Select * from proteccioncivil.Empleado";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();
			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();
			ArraydatosEmpleado = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosEmpleado[i][j] = rset.getString((j+1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void registrarEmpleado( String dni, String nombre, String apellido, String fechanaciemiento, String codParque){
		try {
			String sql = "Insert into proteccioncivil.Empleado (`dni`,`nombre`,`apellido`,`fechanaciemiento`,`codPark`) values (?, ?, ?, ?, ?)";
		
			//String sql2 = "Insert into proteccioncivil.asigna (`codinterno`,`codparque`) values (?, ?)";
			
			PreparedStatement stmt = connect.prepareStatement(sql);
			//PreparedStatement stmt2 = connect.prepareStatement(sql2);
			
			
			
			//stmt2.setString(1, codigointerno2);
			stmt.setString(1, dni);
			//stmt2.setString(2, codparque);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, fechanaciemiento);
			stmt.setString(5, codParque);

			
			stmt.executeUpdate();
			//stmt2.executeUpdate();
			stmt.close();
			//stmt2.close();
			DataEmpl();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		
	}
	
	
	public void DataInsta() {
		try {
			String query = "Select * from proteccioncivil.instalacion";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();
			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosLugar = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosLugar[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void registrarLugar(String nombre, String telefono, String direccion) {
		/*
		 * INSERT INTO `Instalacion` (`codparque`, `nombre`, `telefono`,
		 * `direccion`) VALUES ('3', 'parque3', '982323', 'parque333');
		 */
		try {
			String sql = "Insert into proteccioncivil.Instalacion (`nombre`,`telefono`,`direccion`) values (?, ?, ?)";
			PreparedStatement stmt = connect.prepareStatement(sql);

			stmt.setString(1, nombre);
			stmt.setString(2, telefono);
			stmt.setString(3, direccion);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}
	
	public void DataNotifi() {
		try {
			String query = "Select * from proteccioncivil.notificacion";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosNotificacion = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosNotificacion[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public void registrarNotificacion(String direccion, String urgencia, String tipo) {

		try {
			String sql = "Insert into proteccioncivil.Notificacion (`direccion`,`urgencia`,`tipo`) values ( ?, ?,?)";
			PreparedStatement stmt = connect.prepareStatement(sql);

			stmt.setString(1, direccion);
			stmt.setString(2, urgencia);
			stmt.setString(3, tipo);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}
	
	
	public  ObservableList<Empleado> getDatosEmpleado() {
		masterDatas=FXCollections.observableArrayList();
		for (int g = 0; g < ArraydatosEmpleado.length; g++) {
			empleado = new Empleado(ArraydatosEmpleado[g][0],ArraydatosEmpleado[g][1],ArraydatosEmpleado[g][2],ArraydatosEmpleado[g][3],ArraydatosEmpleado[g][4],ArraydatosEmpleado[g][5]);
			masterDatas.add(empleado);
		}
		return masterDatas;
	}
	
	public  ObservableList<Notificacion> getDatosNotificacion() {
		masterDatas2=FXCollections.observableArrayList();
		for (int g = 0; g < ArraydatosNotificacion.length; g++) {
			notificacion = new Notificacion(ArraydatosNotificacion[g][0],ArraydatosNotificacion[g][1],ArraydatosNotificacion[g][2],ArraydatosNotificacion[g][3]);
			masterDatas2.add(notificacion);
		}
		return masterDatas2;
	}
	
	public  ObservableList<Lugar> getDatosLugar() {
		masterDatas3=FXCollections.observableArrayList();
		for (int g = 0; g < ArraydatosLugar.length; g++) {
			lugar = new Lugar(ArraydatosLugar[g][0],ArraydatosLugar[g][1],ArraydatosLugar[g][2],ArraydatosLugar[g][3]);
			masterDatas3.add(lugar);
		}
		return masterDatas3;
	}

	
	public void BorrarEmpleado(String EMP) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Empleado WHERE codinterno = '" + EMP + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}
	
	public void BorrarNotificacion(String NOT) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Notificacion WHERE codnotificacion = '" + NOT + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarLugar(String LUG) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Instalacion WHERE codparque = '" + LUG + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}	
	
	public void BorrarTodoLugar() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Instalacion";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}
	
	public void BorrarTodoNotificacion() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Notificacion";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarTodoEmpleado() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Empleado";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}
	
	
	public void cargarDatosTablas(){
		DataInsta();
		DataEmpl();
		DataNotifi();

	}
	
}
