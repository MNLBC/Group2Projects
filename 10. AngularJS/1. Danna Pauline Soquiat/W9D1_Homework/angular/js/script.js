var artistApp = angular.module('artistApp', ['ngRoute']);


artistApp.config(function($routeProvider) {

    $routeProvider

    // list page
        .when('/', {
        templateUrl: 'list.html',
        controller: 'artistListCtr'
    })

    // edit page
    .when('/edit/:ID', {
        templateUrl: 'edit.html',
        controller: 'artistEditCtrl'
    })

});


artistApp.factory('artistService', function($http) {
    var savedData = {}
    var jsonArtists;

    function setJsonArtist(data){
        jsonArtists = data;
        return jsonArtists;
    }

    function getJsonArtists(){
        return jsonArtists;
    }

    function saveArtist(ID, name, song) {
        getArtistByID(ID);
    }

    function getArtistByID(id) {
        for(var i = 0; i < jsonArtists.length; i++)
        {
          if(jsonArtists[i].ID == id)
          {
            return jsonArtists[i];
          }
        }
    }

    return {
        getArtistByID: getArtistByID,
        setJsonArtist: setJsonArtist,
        getJsonArtists: getJsonArtists
    }
});

artistApp.run(function($http, artistService) {
     $http.get("json.txt")
        .then(function(response) {
            artistService.setJsonArtist(response.data.records);
    });
    
});

artistApp.controller('artistListCtr', function($scope, $http, $location, artistService) {

    $scope.pagename = 'Artist List';

    $scope.artists =   artistService.getJsonArtists();

    $scope.rowClick = function(artistObj) {
        $location.path( "/edit/" + artistObj.ID );
    };

});


artistApp.controller('artistEditCtrl', function($scope, $http, $routeParams, $location, artistService) {

    $scope.pagename = 'Edit Artist';

    var artistId = $routeParams.ID;

    $scope.artistObj = artistService.getArtistByID(artistId);

    $scope.saveArtist = function(artistObj) {
       alert("artist saved!")
    };

    $scope.backToList = function(){
        $location.path( "/" );
    }

});