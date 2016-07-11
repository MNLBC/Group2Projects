var myApp = angular.module('myApp', []);

myApp.controller('checkOutController', function MyController($scope, $http) {

	$scope.getCart = function() {
		$http({
					method : 'GET',
					url : 'ShowCartServlet'
				}).success(function(data, status, headers, config) {
					$scope.total = 0;
					angular.forEach(data, function(value, key) {
								$scope.total = $scope.total + value.prodSubtotal;

							});
					$scope.cart = data;
					console.log($scope.cart);
				}).error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					console.log('Cannot get cart');
				});

	};

	

	$scope.getCart();

});