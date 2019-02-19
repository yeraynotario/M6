package primero;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ejercicio2_V {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple where apellido='ARROYO'");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf("Emp_no: %s Apellido: %s Oficio: %s Dir: %s Fecha_Alt: %s Salario: %s Comision: %s Departamento: %s%n",emp.getEmpNo(), 
					emp.getApellido(), emp.getOficio(), emp.getDir(), emp.getFechaAlt(), emp.getSalario(), emp.getComision(), emp.getDepart().getDeptNo());
		}
		
		session.close();
		System.exit(0);
	}
}
