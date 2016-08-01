var app = angular.module('myApp', ['ngRoute']);
app.config([ '$routeProvider', function ($routeProvider) { 
   $routeProvider.when('/detailed/:id', { 
      controller: 'traineeController', 
      templateUrl: 'views/Detailed.html' 
    }) 
    .otherwise({ 
      redirectTo: '/' 
    }); 
}]);