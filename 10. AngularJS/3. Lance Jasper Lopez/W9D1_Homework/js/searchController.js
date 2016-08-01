var myApp = angular.module('myApp', ["ngRoute"]);

myApp.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "index.html"
        })
        .when("/form", {
            templateUrl: "form.html"
        });

});

myApp.controller('searchController', function MyController($scope, $http, $location) {

    $scope.info = [
        { "Name": "Max Joe", "Email": "joe@joey.com", "Phone": "12345678911" },
        { "Name": "Manish", "Email": "Ish@mani.com", "Phone": "12345678912" },
        { "Name": "Koniglich", "Email": "Kulig@lig.com", "Phone": "12345678913" },
        { "Name": "Wolski", "Email": "a@wol.com", "Phone": "12345678914" }
    ];


    $scope.filterData = function(crit) {
        console.log('crit', crit);
        $scope.filterCrit = crit;

        console.log('filt', $scope.filterCrit);
    };

    $scope.editItem = function(item) {
        $location.path('/form');
        console.log('item', item);
        $scope.spec = item;
        console.log('spec', $scope.spec);

    };


});
