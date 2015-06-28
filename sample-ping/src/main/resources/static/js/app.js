var pingApp = angular.module("pingApp", ["ui.router"]);

pingApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("home");

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: URLS.partialsHome,
            controller: 'HomeController'
        });
});


pingApp.factory("pingFactory", function ($http) {
    var factory = {};

    factory.getMessageResponse = function(message) {
        return $http.post(URLS.dispatch, {payload: message});
    }

    return factory;
});


pingApp.controller("HomeController", function ($scope, pingFactory) {

    function init() {
        $scope.message = "";
        $scope.errorMessage = "";
    }

    $scope.getMessageResponse = function(message) {
        pingFactory.getMessageResponse(message).success(function(data){
            $scope.message = data;
            $scope.errorMessage = "";
        }).error(function(data, status, headers, config) {
            $scope.errorMessage = data.error;
        });
    }
    init();
});