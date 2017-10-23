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
		     PreparedStatement ps2 = null;
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
		String tmp[]=line.split("\\+");
		codInterno=tmp[0];
		dni=tmp[1];
		nombre=tmp[2];
		apellido=tmp[3];
		fecha=tmp[4];
		codParque=tmp[5];

		    System.out.println(codInterno + "\t" + dni + "\t" + nombre + "\t" +apellido+ "\t" +fecha+ "\t" +codParque);
		    
		    String sql = " INSERT INTO instalacion (codparque) values ('" + codParque + "')";
		    ps = (PreparedStatement) con.prepareStatement(sql);
		    ps.executeUpdate();
		    String sql1 = " INSERT INTO empleado (codinterno,dni,nombre,apellido,fechanaciemiento,codParK) values ('" + dni + "','" + nombre+ "','" + apellido + "','" + fecha+ "','" + codParque + "')";
		    ps2 = (PreparedStatement) con.prepareStatement(sql1);
		    ps2.executeUpdate();
		    
		    


		}


		 br.close();
		 con.close();
		            ps.close();
		            ps2.close();


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