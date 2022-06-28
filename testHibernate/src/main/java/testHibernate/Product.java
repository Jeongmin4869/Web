package testHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity(name="Product2") 
public class Product {
	
	@Id // primary key
	@GeneratedValue // 자동생성
	@Column(name="product_id")
	private int id;
	
	private String name;
	
	private int price;
	
	private String description;
	
}
