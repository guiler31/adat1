package modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public abstract class BDManager implements AccesoDatos {


		public static void main(String[] args) throws ClassNotFoundException, SQLException {

		     String codInterno;
		     String dni;
		     String nombre;
		     String apellido;
		     String fecha;
		     String codParque;

		     PreparedStatement ps = null;
		     Connection con = null;
		     ResultSet rs = null;

		 try {

		 BufferedReader br = new BufferedReader(new FileReader("././Datos/datos.txt"));
		 String username = "root";
	        String pwd = "";
	        String connurl = "jdbc:mysql://localhost/proteccioncivil";

		        con = DriverManager.getConnection(connurl, username, pwd);
		String line = null;
		while((line=br.readLine()) != null){
		String tmp[]=line.split("|");
		codInterno=tmp[0];
		dni=tmp[1];
		nombre=tmp[2];
		apellido=tmp[3];
		fecha=tmp[4];
		codParque=tmp[4];

		    System.out.println(codInterno + "\t" + nombre + "\t" +apellido+ "\t" +fecha+ "\t" +codParque);
		    String sql = "INSERT INTO empleado (codinterno,dni,nombre,apellido,fechanacimiento,codParK) values ('" + codInterno + "','" + dni + "','1','" + nombre+ "','" + apellido + "','" + fecha+ "','" + codParque + "')";

		    ps = (PreparedStatement) con.prepareStatement(sql);

		        ps.executeUpdate();


		}


		 br.close();
		 con.close();
		            ps.close();


		 }   catch(IOException e){
		     e.printStackTrace();
		 }


		 }
		@Override
		public void addOne(String[] datos) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String[][] leeTodos() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void escribeTodos(String[][] listaDatos) {
			// TODO Auto-generated method stub
			
		}
		
	}




