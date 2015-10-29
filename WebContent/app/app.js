// MODULE
var fuelupApp = angular.module('fuelupApp', ['ngTable','ngRoute']);

fuelupApp.config(function($routeProvider) {
    
    $routeProvider
    
    .when('/', {
        templateUrl: 'all-trx.html',
        controller: 'allTrxController'
    })
    
    .when('/view/:id',{
        templateUrl: 'view.html',
        controller: 'viewTrxController'
    })
    
    .when('/edit/:id',{
        templateUrl: 'edit.html',
        controller: 'viewTrxController'
    })
});

// CONTROLLERS
fuelupApp.controller('allTrxController', ['$scope', '$http', function ($scope, $http) {
    
    $http.get('/fuelup-monitor/rest/v1/transaction/all')
        .success(function(result) {
        
            $scope.transactions = result;
            //$scope.tableParams = new NgTableParams({}, {dataset: $scope.transactions});
        })
        .error(function(data, status){
        
        });
}]);

fuelupApp.controller('viewTrxController', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
    
    var id = $routeParams.id
    
    $http.get('/fuelup-monitor/rest/v1/transaction/fetch/' + id)
        .success(function(result) {
        
            $scope.transaction = result;
            //$scope.tableParams = new NgTableParams({}, {dataset: $scope.transactions});
        })
        .error(function(data, status){
        
        });
}]);

fuelupApp.controller('updateTrxController', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
    
    var id = $routeParams.id
    
    $http.put('/fuelup-monitor/rest/v1/transaction/modify/' + id)
        .success(function(result) {
        
            $scope.transaction = result;
            //$scope.tableParams = new NgTableParams({}, {dataset: $scope.transactions});
        })
        .error(function(data, status){
        
        });
}]);