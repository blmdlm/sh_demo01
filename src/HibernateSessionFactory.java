import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-22 下午4:06:57
 * 加载配置文件的类
 */
public class HibernateSessionFactory {
	 private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	    private static Configuration configuration = new Configuration();    
	    private static SessionFactory sessionFactory;
	    private static String configFile = CONFIG_FILE_LOCATION;

	    static {
	        try {
	            configuration.configure(configFile);
	            sessionFactory = configuration.buildSessionFactory();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public HibernateSessionFactory() {
	    }

	    /**
	     *  Rebuild hibernate session factory
	     *
	     */
	    public static void rebuildSessionFactory() {
	        try {
	            configuration.configure(configFile);
	            sessionFactory = configuration.buildSessionFactory();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     *  return session factory
	     *
	     */
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	
	
	public Session getSession(){
		sessionFactory=getSessionFactory();
		return sessionFactory.openSession();
	}
}
