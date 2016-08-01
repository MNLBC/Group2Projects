var app = angular.module('app', ["ngRoute"]);

app.controller('UserController', function($scope, $http, $location){
	$scope.users = userlist;
	$scope.search = "";
	$scope.criteria = "";
	$scope.searchuser = function(crit){
		$scope.search = crit;
		//console.log($scope.search);
		//console.log("dumaan")
	};
	$scope.viewinfo = function(user){
		$location.path('/viewinfo');
		$scope.selecteduser = user;
	};
});	
	
app.config(function($routeProvider) {
    $routeProvider
	.when("/", {
        templateUrl : "index.html"
    })
    .when("/viewinfo", {
        templateUrl : "viewinfo.html"
    });
});

var userlist = [
	{
		name: "sample",
		email: "sample2",
		phone: "8908080"
	},
	{
		name: "Meynard Denoyo",
		email: "mrdenoyo@gmail.com",
		phone: "8908080"
	},
	{
		name: "Mark Anthony Andes",
		email: "andesma@gmail.com",
		phone: "09876"
	}
];