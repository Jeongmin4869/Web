package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	//Lazy : product를 필요할때만 가져온다
	//EAGER : product를 다 가져온다
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL , fetch=FetchType.LAZY)
	private Set<Product> product = new HashSet<Product>();
	
}
