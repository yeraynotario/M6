package JDBC_2;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio5 {
	 public static void main (String[] args){
		 Scanner lector = new Scanner(System.in);
		 
		 try{
			 System.out.println("Introduce el departamento:");
			 int departa = lector.nextInt();
			 
			 System.out.println("Introduce el incremento:");
			 int increm = lector.nextInt();
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conexion = DriverManager.getConnection ("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			 
			 String sql = String.format("UPDATE emple SET salario=(salario+'"+increm+"') WHERE dept_no='"+departa+"';");
			 System.out.println(sql);
			 Statement sentencia = conexion.createStatement();
			 int filas = sentencia.executeUpdate(sql);
			 System.out.printf("Filas afectadas: %d %n", filas);
			 sentencia.close();
			 conexion.close();
			 lector.close();
		 }
		 catch (ClassNotFoundException cn) {cn.printStackTrace();}
		 catch (SQLException e) {e.printStackTrace();}
		 }
}


