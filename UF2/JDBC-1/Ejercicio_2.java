package JDBC_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_2 {
	public static void main(String[] args) {
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT emple.apellido, max(emple.salario), depart.dnombre from emple, depart";
			ResultSet result = sentencia.executeQuery(sql);
 
			while (result.next()){
				System.out.printf("%s, %d, %s, %n",
				result.getString(1),
				result.getInt(2),
				result.getString(3));
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
