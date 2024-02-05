package ehGarden;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArboles {

	final static String host = "localhost";
	final static String BBDD = "eh_garden2";
	final static String usuario = "root";
	final static String contrasenia = "";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Arbol> arboles = new ArrayList<Arbol>();

		int opcion;

		do {

			System.out.println("Elige una opción:");
			System.out.println("1. Insertar árbol");
			System.out.println("2. Eliminar árbol");
			System.out.println("3. modificar informacion del arbol");
			System.out.println("4. visualizar arboles");
			System.out.println("0. Salir");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case 1:
				INSERTAR();
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				VISUALIZAR();
				break;
			case 5:
				
			}
			
		} while (opcion != 0);
		System.out.println("Programa finalizado.");
	}

	
	private static void VISUALIZAR() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + BBDD, usuario,
					contrasenia);

			Statement st = conexion.createStatement();

			String sentenciaSelect = "SELECT * FROM arboles";
			Statement st2 = conexion.createStatement();
			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + " - " + resultado.getString(2));
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void INSERTAR() {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Ingrese los detalles del árbol:");
			System.out.println("nombre_comun:\n");
			String nombreComun = scan.nextLine();
			System.out.println("nombre_cientifico:\n");
			String nombreCientifico = scan.nextLine();
			System.out.println("altura:\n");
			int altura = Integer.parseInt(scan.nextLine());
			System.out.println("origen:\n");
			String origen = scan.nextLine();
			System.out.println("idHabitat:\n");
			int idHabitat = Integer.parseInt(scan.nextLine());
			System.out.println("fecha_encontrada:\n");
			Date fechaEncontrada = Date.valueOf(scan.nextLine());
			System.out.println("singular:\n");
			boolean singular = Boolean.parseBoolean(scan.nextLine());
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + BBDD, usuario,
					contrasenia);

			Statement st = conexion.createStatement();

			PreparedStatement preparedSt = conexion.prepareStatement(
					"INSERT INTO arboles (nombre_comun,nombre_cientifico,id_habitat,altura,origen,fecha_encontrada,singular) VALUES (?,?,?,?,?,?,?)");
			
			preparedSt.setString(1, nombreComun);
			preparedSt.setString(2, nombreCientifico);
			preparedSt.setInt(3, idHabitat);
			preparedSt.setInt(4, altura);
			preparedSt.setString(5, origen);
			preparedSt.setDate(6, fechaEncontrada);
			preparedSt.setBoolean(7, singular);
			
			preparedSt.execute();

			System.out.println("fila insertada");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse con la BBDD");
			e.printStackTrace();
		}
	}
	public static void ELIMINAR() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + BBDD, usuario,
				contrasenia);

		Statement st = conexion.createStatement();
		
	
	}

}
