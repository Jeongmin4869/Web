<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script src="<c:url value="/resources/js/controller.js"/>"></script>

<div class="container-wrapper">
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h2>Cart</h2>
				
				<p>All the selected products in YOUR shopping cart</p>
			
			</div>
		</div>
		
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')"> <!-- controller 에서 model 에넣어준 id값 -->
				<a class="btn btn-warning pull-left" ng-click="clearCart()">
					<i class="fa fa-trash"></i> Clear Cart
				</a>
				
				<br/>
				
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th></th>
						<th>Action</th>
						<th></th>
					</tr>
				
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.name}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a class="btn btn-danger" ng-click="minusItem(item.product.id)">
							<i class="fa fa-minus"></i>minus</a></td>
						<td><a class="btn btn-danger" ng-click="addItem(item.product.id)">
							<i class="fa fa-plus"></i>plus</a></td>
						<td><a class="btn btn-danger" ng-click="removeFromCart(item.product.id)">
							<i class="fa fa-close"></i>remove</a></td>
					</tr>
					
					<tr>
						<td></td>
						<td></td>
						<td>Grand Total</td>
						<td>{{calGrandTotal()}}</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
				
				<a class="btn btn-info" href="<c:url value="/products" />" class="btn btn-default">Continue Shopping</a>
				
			</div>
		</section>
	</div>
</div>


