package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*******************
 * 
 * Hibernate가 이 class에 해당되는 내용을 table로 만들어준다.
 * name을 사용해 table의 이름 지정
 * Entity bean으로 등록
 *
 ******************/
@Entity(name="Product") 
public class Product {
	
	@Id // primary key
	@GeneratedValue // 자동생성
	@Column(name="product_id")
	private int id;
	
	private String name;
	
	private int price;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL) // persist, delete
	@JoinColumn(name="category_id")
	private Category category;
	
}
