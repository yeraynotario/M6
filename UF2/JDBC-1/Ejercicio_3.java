package JDBC_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio_3 {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		try{
			System.out.println("Introduce la localidad:");
			String localidad = lector.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT depart.dept_no, emple.apellido from depart join emple on depart.dept_no=emple.dept_no where loc='"+localidad+"';";
			ResultSet result = sentencia.executeQuery(sql);
 
			while (result.next()){
				System.out.printf("%s, %s, %n",
				result.getString(1),
				result.getString(2));
			}
			
			result.close();
			sentencia.close();
			conexion.close();
			
		} catch (ClassNotFoundException cn) { 
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
