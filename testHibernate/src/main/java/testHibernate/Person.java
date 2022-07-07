package testHibernate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
	
	private int id;
	
	private String firstName;
	private String lastname;
	

}
