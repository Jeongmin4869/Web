package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("notebook1");
		product1.setPrice(100);
		product1.setDescription("Powerful notebook!!");
		product1.setCategory(category1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(1000);
		product2.setDescription("Powerful desktop!!");
		product2.setCategory(category1);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(10000000);
		product3.setDescription("대중적인 자동차!!");
		product3.setCategory(category2);
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// 객체를 저장하여 DB에 반영. sql statement 를 대신함.
		session.save(product1);
		session.save(product2);
		session.save(product3);
		
		product1.setCategory(null);
		session.delete(product1); // category1 - product1, product2 // 단독은 에러
		
		tx.commit();
		session.close();
		
	}

}
