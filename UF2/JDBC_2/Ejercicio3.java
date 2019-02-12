package JDBC_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio3 {
	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet result = dbmd.getPrimaryKeys("ejemplo","ejemplo","depart");
			ResultSet result2 = dbmd.getExportedKeys("ejemplo","ejemplo","depart");
		       
			
			while (result.next()){
				String columnName = result.getString("COLUMN_NAME");
			    System.out.println("getPrimaryKeys(): columnName = " + columnName);
			}
			
			while (result2.next()){
				String fkColumnName = result2.getString("FKCOLUMN_NAME");
			    System.out.println("getExportedKeys(): columnName2 = "+fkColumnName);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
