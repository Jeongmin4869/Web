package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShippingAddress {
	
	private int id;
	
	private String address;
	
	private String country;
	
	private String zipCode;

}
