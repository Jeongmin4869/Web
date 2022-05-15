import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.ac.hansung.spring.csemall.Offer;
import kr.ac.hansung.spring.csemall.OfferDAO;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/spring/csemall/beans/beans.xml");
	
		OfferDAO offerDAO = (OfferDAO)context.getBean("offerDAO");
		System.out.println("The record count is " + offerDAO.getRowCount());
		
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer : offerList) {
			System.out.println(offer);
		}
		
		Offer offer = new Offer("nykim", "nykim@hansung.ac.kr", "an instructor of sprinf framework");
		if(offerDAO.insert(offer)) {
			System.out.println("Object is inserted successfully");
		}
		else {
			System.out.println("Object insertion failed");
		}
		
		offer = offerDAO.getOffer("nykim");
		System.out.println(offer);
		
		offer.setName("Jeongmin Kim");
		if(offerDAO.update(offer))
			System.out.println("update with object: " + offer);
		else 
			System.out.println("Cannot update an object");
		
		context.close();
	}

}
