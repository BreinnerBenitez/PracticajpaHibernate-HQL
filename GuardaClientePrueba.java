package objetoRelacionHibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class GuardaClientePrueba {

	public static void main(String [] arg) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
	   Session miseccion= miFactory.openSession();
	   
	   
	   
	   try {
		   
		   Clientes cliente1 = new  Clientes("ana","holguin","italia");
		  
		   miseccion.beginTransaction();
		   
		   miseccion.save(cliente1);
		   
		   miseccion.getTransaction().commit();
		   
		   System.out.println("registro insertado correctamente");
		   
		   // lectura de registro 
		   
		   miseccion.beginTransaction();
		   
		   System.out.println("lectura de registro con id: "+cliente1.getId());
		   
		   Clientes clienteInsertado= miseccion.get(Clientes.class, cliente1.getId());
		   
		   System.out.println("registro: "+clienteInsertado);
		   
		   miseccion.getTransaction().commit();
		   
		   System.out.println("terminado");
		   
		   miseccion.close();
		   
	   }catch(Exception e) {
		   
		   e.printStackTrace();
		   
	   }finally {
		   
		   miFactory.close();
		   miseccion.close();
	   }
	
	}
	
}
