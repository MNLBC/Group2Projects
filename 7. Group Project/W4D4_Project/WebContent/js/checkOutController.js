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

	$scope.getDataFromServerByCat = function(cat) {
		$http({
					method : 'GET',
					url : 'getProducts',
					params : {
						category : cat
					}
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
		var data = $.param({
					prodId : id
				}

		);
		var config = {
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
			}
		}

		$http.post('AddToCart', data, config).success(
				function(data, status, headers, config) {
					// $scope.totalPrice = $scope.totalPrice + price
					// $scope.quantity = $scope.quantity +1;
					alert('Successfully added to cart');
					$scope.PostDataResponse = data;
				}).error(function(data, status, header, config) {
					console.log('Add to Cart Error');
				});
	};

	$scope.getCountPerCategory = function() {
		$http({
					method : 'GET',
					url : 'CategoryCount'
				}).success(function(data, status, headers, config) {
					var all = data.Digital + data.Casual + data.Luxury
							+ data.Dress;
					console.log('all', all);
					$scope.catCount = data;
					$scope.catCount.All = all;

					console.log($scope.catCount);
				}).error(function(data, status, headers, config) {
			console.log('Cannot get category count');
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});

	};

	$scope.getCart();

});