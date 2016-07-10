var myApp = angular.module('myApp', []);

myApp.controller('productsController', function MyController($scope, $http) {

	$scope.getDataFromServer = function() {
		$http({
					method : 'GET',
					url : 'getProducts'
				}).success(function(data, status, headers, config) {
					angular.forEach(data, function(value, key) {
								// console.log(value);

								if (value.prodSale < 1) {

									var oldVal = value.prodSale;
									var newVal = 0;
									newVal = 100 - (oldVal * 100);
									value.prodSale = newVal;
									data[key] = value;
								} else {
									// console.log('no discount')
									value.prodSale = null;
									data[key] = value;
								}

							});
					$scope.products = data;
					console.log($scope.products);
				}).error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});

	};

	$scope.addToCart = function(id) {
		// use $.param jQuery function to serialize data from JSON
		var data = $.param(
		{prodId : id}
		
);
		var config = {
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}

		$http.post('AddToCart', data, config).success(
				function(data, status, headers, config) {
					alert('Successfully added to cart');
					$scope.PostDataResponse = data;
				}).error(function(data, status, header, config) {
					console.log('Add to Cart Error');
				});
	};

	$scope.getDataFromServer();

});