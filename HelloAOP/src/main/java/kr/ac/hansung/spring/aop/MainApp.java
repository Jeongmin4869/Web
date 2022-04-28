package kr.ac.hansung.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/spring/aop/beans/animal.xml");
	
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		
		context.close();
	}

}
