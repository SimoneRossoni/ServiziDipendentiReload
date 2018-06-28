var app = angular.module('serviziDipendentiReloadedApp',['ui.router','UtilFilter']); 

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
	
		$urlRouterProvider.otherwise('/');
	
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/listAvvisi',
                controller:'AvvisiController',
                controllerAs:'ctrl'                
        });
        
        
    }]);

app.config(['$httpProvider', 
	function($httpProvider) {
	  $httpProvider.interceptors.push('AuthInterceptor');
	}]);