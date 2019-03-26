import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import net.xqj.exist.ExistXQDataSource;

public class Ejercicio2_ActXQ {
	public static void main(String[] args) {
		try {
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			//XQPreparedExpression consulta;

			//consulta = conn.createExpression();
			XQExpression consulta = conn.createExpression();
			String actual = ("update insert " + "DEP_ROW, DEPT_NO='50',DNOMBRE='INFORMÁTICA',LOC='Valencia'"+"into /departamentos");
		    //consulta.executeCommand("removeDocument($docId)");
			
			
			
			consulta.executeCommand(actual);
			
			
			System.out.println("Se ha modificado el usuario!");
		    consulta.close();
			
		} catch (XQException e) {
			e.printStackTrace();
			System.out.println("Error!");
		} 
	}
}