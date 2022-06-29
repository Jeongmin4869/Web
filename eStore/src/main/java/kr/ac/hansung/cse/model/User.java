package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private ShippingAddress shippingAddress;
	
	private boolean enabled = false;
	
	private String authority;
	

}
