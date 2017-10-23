package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;

public class FileManager implements AccesoDatos {

	private Connection connect;

	@Override
	public void addOne(String[] datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[][] leeTodos() {
		String[][] auxiliar = null;

		// SELECT * de lugares
		return auxiliar;
	}

	public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);

		}
		b.close();
	}

	@Override
	public void escribeTodos(String[][] listaDatos) {
		

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("Datos/datos.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++)
				pw.println("Linea " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
public void escribeTodos() {
		

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("Datos/datos2.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++)
				pw.println("Linea " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}