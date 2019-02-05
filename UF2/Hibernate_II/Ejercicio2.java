package primero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ejercicio2 {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Emple emp = new Emple();
		
		Depart dep = new Depart();
		dep.setDeptNo((byte) 10);
		
		emp.setEmpNo(0);
		emp.setDepart(dep);
		emp.setApellido("NOTARIO");
		emp.setOficio("EMPLEADO");
		emp.setDir(null);
		emp.setFechaAlt(null);
		emp.setSalario(4100);
		emp.setComision(null);
		

		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
		}
}
