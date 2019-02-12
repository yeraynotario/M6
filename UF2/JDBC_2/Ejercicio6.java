package JDBC_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Ejercicio6 {
	public static void main (String[] args){
		 try{
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			 
			 String sql = String.format("CREATE VIEW Totales AS SELECT dept_no, dnombre, emple.salario FROM depart join emple using(dept_no);");
			 System.out.println(sql);
			 Statement sentencia = conexion.createStatement();
			 int filas = sentencia.executeUpdate(sql);
			 String sql2 = String.format("Select * from Totales;");
			 System.out.println(sql2);
			 sentencia.close();
			 conexion.close();
			 
		 }
		 catch (ClassNotFoundException cn) {cn.printStackTrace();}
		 catch (SQLException e) {e.printStackTrace();}
		 }
}





