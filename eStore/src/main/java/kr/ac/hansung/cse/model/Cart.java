package kr.ac.hansung.cse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cart implements Serializable {
	
	private static final long serialVersionUID = -7383420736137539222L;

	private int id;
	
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	private double grandTotal;
	
}
