package objetoRelacionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultasClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();

		Session miseccion = miFactory.openSession();

		try {
			
			// comenzamos la seccion 
			
			
			miseccion.beginTransaction();
			
			
			//consultas clientes 
			
			String HQL=" from Clientes";
			
			List <Clientes> listaclientes= miseccion.createQuery(HQL).getResultList();
			
			// mostrar los clientes 
			
			for (Clientes unCliente:listaclientes) {
				
				
				System.out.println(unCliente);
				
			}
			
			System.out.println("PARTE DE ABAJO LOS BENITEZ");
			
			// consulta dame los bentiez
			
			 HQL=" from Clientes cl Where cl.apellido='benitez'";
			
			listaclientes= miseccion.createQuery(HQL).getResultList();
			
			// mostrar  los clientes con benitez 
			
			for (Clientes unCliente:listaclientes) {
				
				
				System.out.println(unCliente);
				
			}
			
			System.out.println("PARTE DE ABAJO LOS HOLGUIN");
			
			// CONSULTA  CON OPERADOR LOGICO 
			
			 HQL="from Clientes cl Where cl.apellido='holguin' or cl.direccion='candelaria'";
			
			listaclientes= miseccion.createQuery(HQL).getResultList();
			
			// OPERADOR LOGICO MUESTRA CONSULTA 
			
			for (Clientes unCliente:listaclientes) {
				
				
				System.out.println(unCliente);
				
			}
			
			
			
			
			//COMMIT
			 miseccion.getTransaction().commit();
			 
			 

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			miFactory.close();
			miseccion.close();
		}

	}

}