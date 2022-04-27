package kr.ac.hansung.spring.di;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {
	
	//@Autowired // wiring by type
	//@Qualifier(value = "qf_dog")
	@Resource(name = "dog") // wiring by name
	private AnimalType animal;

	public void play() {
		animal.sound();
	}
	
}
