package hbm.xml;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class HibernateXMLConfStarter 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration configutation= new Configuration();
        configutation.configure("hibernate.cfg.xml");
        
        
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configutation.getProperties()).buildServiceRegistry();
        SessionFactory factory = configutation.buildSessionFactory(serviceRegistry);
 
        Session session =factory.openSession();
        Transaction transaction =session.beginTransaction();
        
        
        Person person = new Person("Andr","wewe",34);
        session.persist(person);
        
        
//        Car car= new Car();
//        session.persist(car);
        
        transaction.commit();
        session.close();
    
    }

}
