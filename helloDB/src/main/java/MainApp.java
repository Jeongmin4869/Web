import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.ac.hansung.spring.csemall.OfferDAO;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/spring/csemall/beans/beans.xml");
	
		OfferDAO offerDAO = (OfferDAO)context.getBean("offerDAO");
		System.out.println("The record count is " + offerDAO.getRowCount());
		context.close();
	}

}
