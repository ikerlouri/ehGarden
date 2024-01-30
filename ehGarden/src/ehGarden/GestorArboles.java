package ehGarden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArboles {

	public static void main(String[] args) {
		final String host = "localhost";
		final String BBDD = "eh_garden";
		final String usuario = "root";
		final String contrasenia = "";

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

				try {	
				
				System.out.println("Ingrese los detalles del árbol:");
				System.out.println("nombre_comun:\n");
				String nombreComun = scan.nextLine();
				System.out.println("nombre_cientifico:\n");
				String nombreCientifico = scan.nextLine();
				System.out.println("habitat:\n");
				String habitat = scan.nextLine();
				System.out.println("altura:\n");
				int altura = Integer.parseInt(scan.nextLine());
				System.out.println("origen:\n");
				String origen = scan.nextLine();
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				

					
					Connection conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + BBDD, usuario,
							contrasenia);

					Statement st = conexion.createStatement();

					PreparedStatement preparedSt = conexion.prepareStatement("INSERT INTO arboles (nombre_comun,nombre_cientifico,habitat,altura,origen) VALUES (?,?,?,?,?)");
					preparedSt.setString(1 , nombreComun );
					preparedSt.setString(2, nombreCientifico);
					preparedSt.setString(3, habitat);
					preparedSt.setInt(4, altura);
					preparedSt.setString(5, origen);
					preparedSt.execute();

					System.out.println("fila insertada");

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("Error al conectarse con la BBDD");
					e.printStackTrace();
				}
				
				break;
			case 2:
				// Lógica para eliminar árbol
				if (!arboles.isEmpty()) {
					System.out.println("Árboles disponibles:");
					for (Arbol a : arboles) {
						System.out.println("ID: " + a.getId() /* otros detalles */);
					}
					System.out.print("Ingrese el ID del árbol a eliminar: ");
					int idEliminar = Integer.parseInt(scan.nextLine());

					System.out.println("Árbol eliminado con éxito.");
				} else {
					System.out.println("No hay árboles para eliminar.");
				}
				break;
			// Otros casos según sea necesario
			}
		} while (opcion != 0);

		System.out.println("Programa finalizado.");
	}
}
