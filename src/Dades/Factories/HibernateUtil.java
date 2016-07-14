package Dades.Factories;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
	private static HibernateUtil instance = new HibernateUtil();
	public static HibernateUtil getInstance(){return instance;}
	
    private SessionFactory sessionFactory;
    
     
    public SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);       
        }
         
        return sessionFactory;
    }
    
    public Session openSession() throws HibernateException{
    	return sessionFactory.openSession();
    }
    public void closeSession() throws HibernateException{
    	sessionFactory.getCurrentSession().close();
    }
}