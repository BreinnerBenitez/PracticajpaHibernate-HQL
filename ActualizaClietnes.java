package objetoRelacionHibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class ActualizaClietnes {

	public static void main(String [] arg) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
	   Session miseccion= miFactory.openSession();
	   
	   
	   
	   try {
		   
		   
		 //  int clienteid=4;
		  
		   miseccion.beginTransaction();
		   
		 //  Clientes miCliente=miseccion.get(Clientes.class, clienteid);
		   
		 //  miCliente.setApellido("holguin");
		   
		   miseccion.createQuery("update Clientes cl set cl.apellido='guerrero' where cl.apellido LIKE 'h%'").executeUpdate();
		   
		   
		   
		   miseccion.getTransaction().commit();
		   
		   System.out.println("registro actualizado correctamente");
		   
		 
		   

		   
	   }catch(Exception e) {
		   
		   e.printStackTrace();
		   
	   }finally {
		   
		   miFactory.close();
		   miseccion.close();
	   }
	
	}
	
}
