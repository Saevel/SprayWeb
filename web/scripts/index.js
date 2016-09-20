var mainModule = angular.module('MainModule', ['ngRoute']);

mainModule.controller('MainController', function($scope, $http){

    $http
        .get("/monitoring/abcde")
        .success(function(data){
            $scope.name = data.name;
            $scope.surname = data.surname;
        })
        .error(function(){
            alert("Error fetching data from server");
        });
});

mainModule.config(function($routeProvider){
    $routeProvider
        .when("/", {
            templateUrl: 'views/main.html',
            controller: 'MainController'
        });
});