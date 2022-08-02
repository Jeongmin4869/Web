package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = -567117648902464025L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //sequence 테이블 생성 X
	@Column(name="product_id")
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	
	private String category;
	
	@Min(value=0, message="The product price must not be less than zero")
	private int price;
	
	@NotEmpty(message="The product manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product unitInStock must not be less than zero")
	private int unitInStock;
	
	private String description;
	
	@Transient // db에 저장하지 않는다, 다른 filesystem에 저장 할 예정
	private MultipartFile productImage; 
	
	//실제로 저장되는건 파일의 이름
	private String imageFilename;
	
}
