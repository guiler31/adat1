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

		     String codNoti;
		     String direccion;
		     String urgencia;
		     String tipo;


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
		String tmp[]=line.split("\\+");
		codNoti=tmp[0];
		direccion=tmp[1];
		urgencia=tmp[2];
		tipo=tmp[3];
		

		    System.out.println(codNoti + "\t" + direccion + "\t" +urgencia+ "\t" +tipo);
		    String sql = " INSERT INTO notificacion (direccion,urgencia,tipo) values ('" + direccion + "','" + urgencia + "','" + tipo + "')";

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