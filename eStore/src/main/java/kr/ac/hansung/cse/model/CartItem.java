package kr.ac.hansung.cse.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartItem implements Serializable{

	//version id
	private static final long serialVersionUID = -7296960050350583877L;

	private int id;
	
	private Cart cart;
	
	private Product product;
	
	private int quantity;
	
	private double totalPrice;

}
