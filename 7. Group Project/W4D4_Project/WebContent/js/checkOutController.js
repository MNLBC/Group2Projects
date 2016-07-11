var myApp = angular.module('myApp', []);

myApp.controller('checkOutController', function MyController($scope, $http) {
	$scope.totalCartItems = 0;
	$scope.getCart = function() {
		$http({
					method : 'GET',
					url : 'ShowCartServlet'
				}).success(function(data, status, headers, config) {
					$scope.total = 0;
					angular.forEach(data, function(value, key) {
								$scope.total = $scope.total
										+ value.prodSubtotal;

							});
					$scope.cart = data;
					console.log($scope.cart);
				}).error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					console.log('Cannot get cart');
				});

	};

	$scope.checkout = function() {
		$http({
					method : 'GET',
					url : 'checkoutServlet'
				}).success(function(data, status, headers, config) {
					alert('Transaction successful. Please prepare Cash on Delivery')
					$scope.cart = data;
					console.log($scope.cart);
				}).error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					console.log('Cannot complete transaction');
				});

	};
		
		$scope.getCartCount = function() {
		$http({
					method : 'GET',
					url : 'ShowCartServlet'
				}).success(function(data, status, headers, config) {
					
					var ctr = 0;
					angular.forEach(data, function(value, key) {
								ctr = ctr +1;

							});
					$scope.totalCartItems= ctr;
					
				}).error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					console.log('Cannot get cart');
				});

	};

	$scope.getCart();
	$scope.getCartCount();

});