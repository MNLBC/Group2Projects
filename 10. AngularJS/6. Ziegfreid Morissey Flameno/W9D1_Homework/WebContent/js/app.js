// app.js - Ziggy 2016/08/01
var app = angular.module('searchApp', [ 'ngRoute' ]);

// this is where the routing is declared
app.config([ '$routeProvider', function($routeProvider) {
   $routeProvider.when('/student', {
      templateUrl : 'html/student.html'
   }).otherwise({
      redirectTo : '/'
   });
} ]);

//main controller containing the student data
app.controller('mainController', function($scope, $http, $location) {
   $scope.sortType = 'name'; // set the default sort type
   $scope.sortReverse = false; // set the default sort order
   $scope.searchStudent = ''; // set the default search/filter term

   // create the list of students
   $scope.students = [ {
      name : 'Danna Pauline Soquiat',
      email : 'soquida@oocl.com',
      phone : 1
   }, {
      name : 'Kassandra Ysabel Fuentes',
      email : 'fuentka@oocl.com',
      phone : 2
   }, {
      name : 'Lance Jasper Lopez',
      email : 'lopezla@oocl.com',
      phone : 3
   }, {
      name : 'Meynard Denoyo',
      email : 'denoyme@oocl.com',
      phone : 4
   }, {
      name : 'William Kalingasan',
      email : 'kalinwi@oocl.com',
      phone : 5
   }, {
      name : 'Ziegfreid Morissey Flameño',
      email : 'flamezi2@oocl.com',
      phone : 6
   } ];

   // show student data
   $scope.showStudent = function(student) {
      $location.path('/student');
      $scope.student = student;
      console.log(student);
   };

});