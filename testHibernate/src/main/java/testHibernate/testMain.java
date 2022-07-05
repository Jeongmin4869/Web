package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {

		/*		
 		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();
		*/
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("notebook1");
		product.setPrice(100);
		product.setDescription("Powerful notebook!!");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// 객체를 저장하여 DB에 반영. sql statement 를 대신함.
		session.save(product);
		
		tx.commit();
		session.close();
		
	}

}
