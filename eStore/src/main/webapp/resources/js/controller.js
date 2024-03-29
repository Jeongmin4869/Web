var cartApp = angular.module('cartApp', []);

cartApp.controller("cartCtrl", function($scope, $http) {

	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart();
	};

	$scope.refreshCart = function() {
		/* get메서드를 통해 rest server 로부터 cart 정보를 가져와 저장함. */
		$http.get('/eStore/api/cart/' + $scope.cartId).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	};

	$scope.clearCart = function() {

		$scope.setCsrfToken();

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.addToCart = function(productId) {

		$scope.setCsrfToken();

		$http.put('/eStore/api/cart/add/' + productId).then(
				function successCallback() {
					$scope.refreshCart();
					alert("Product successfully added to the cart!");
				}, function errorCallback() {
					alert("Adding to the cart failed!");
				});
	};
	
	$scope.addItem = function(productId) {

		$scope.setCsrfToken();

		$http.put('/eStore/api/cart/add/' + productId).then(
				function successCallback() {
					$scope.refreshCart();
				}, function errorCallback() {
				});
	};
	
	$scope.minusItem = function(productId) {

		$scope.setCsrfToken();

		$http.put('/eStore/api/cart/update/' + productId).then(
				function successCallback() {
					$scope.refreshCart();
				}, function errorCallback() {
					alert("Adding to the cart failed!");
				});
	};

	$scope.removeFromCart = function(productId) {

		$scope.setCsrfToken();

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartitem/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.calGrandTotal = function() {
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	};



	$scope.setCsrfToken = function() {
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");

		/* http의 header 정보에 csrftoken 값이 담겨지게된다. */
		$http.defaults.headers.common[csrfHeader] = csrfToken;
	}

});