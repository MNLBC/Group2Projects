var mainapp = angular.module('mainapp',['ngRoute']);
mainapp.config([ '$routeProvider', function($routeProvider) {
   $routeProvider.when('/page2', {
      templateUrl : 'view/page2.html'
   }).otherwise({
      redirectTo : '/'
   });
} ]);

mainapp.controller('maincontroller',function($scope,$location){
	var data = [
	{"fullname" : "William Kalingasan",
		"email" : "williamkalingasan@gmail.com",
		"mobile" : "09063182296"
	},
	{"fullname" : "Jana Paulyn Dimapilis",
		"email" : "paulyndimapilis@gmail.com",
		"mobile" : "09268784075"
	},
	{"fullname" : "Xander Sarmiento",
		"email" : "xander.sarmiento@gmail.com",
		"mobile" : "09153489299"
	},
	{"fullname" : "Joan Margaret Hernandez",
		"email" : "meggyhernandez@gmail.com",
		"mobile" : "09273362156"
	},
	{"fullname" : "Micah Janela Galang",
		"email" : "micah.janela@gmail.com",
		"mobile" : "09158752896"
	}
	];
	$scope.records = data;
	$scope.searchName = "";
	$scope.searchValue = "";
	
	$scope.searchClick = function(){
		$scope.searchValue = $scope.searchName;
	}
	
	$scope.doubleClick = function(rec){
		$location.path('/page2');
		$scope.recDetail = rec;
	};
});