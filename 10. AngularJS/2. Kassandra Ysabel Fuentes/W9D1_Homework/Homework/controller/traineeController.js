app.controller('traineeController', function($scope, $routeParams, $location) {
    $scope.trainee = {
		 firstname: '',
		 lastname: '',
         email: '',
		 fullName: function () {
			  var trainee;
			  trainee= $scope.trainee;
			  return trainee.firstname + ' ' + trainee.lastname;
		  }		  
		};
    $scope.listOfTrainees = [
        {
            id:1,
            firstname: 'Kassandra Ysabel',
            lastname: 'Fuentes',
            email: 'fuentka@oocl.com',
            contact: 321456
        },
        {
            id:2,
            firstname: 'Danna Pauline',
            lastname: 'Soquiat',
            email: 'soquida@oocl.com',
            contact: 132465
        },
        {
            id:3,
            firstname: 'Ziegfreid Morissey',
            lastname: 'Flameno',
            email: 'flamezi@oocl.com',
            contact: 321654
        },
        {
            id:4,
            firstname: 'Lance Jasper',
            lastname: 'Lopez',
            email: 'lopezla@oocl.com',
            contact: 123654
        },
        {
            id:5,
            firstname: 'Meynard',
            lastname: 'Denoyo',
            email: 'denoyme@oocl.com',
            contact: 654321
        },
        {
            id:6,
            firstname: 'William',
            lastname: 'Kalingasan',
            email: 'kaliwi2@oocl.com',
            contact: 123456
        }
    ];
    $scope.id = $routeParams.id;
    $scope.search = function() {
        angular.forEach($scope.listOfTrainees, function(value, key) {
            if ($scope.firstname === value.firstname || value.lastname === $scope.lastname || value.email === $scope.email) {
                $scope.listOfTrainees = [
                    {
                        id: value.id,
                        firstname: value.firstname,
                        lastname: value.lastname,
                        email: value.email
                    }
                ];
                return listOfTrainees;
            }
        });
    };
    $scope.detailed = function(id)
    {
      $location.path('/detailed/' + id); 
    };  
	});