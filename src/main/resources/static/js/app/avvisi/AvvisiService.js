'use strict';

//app.factory('AvvisiService', ['$http', function ($http) {
//	
//	var urlBase = 'http://localhost:8080/SpringBootCRUDApp/avvisi';
//    var AvvisiService = {};
//
//    AvvisiService.getAll = function () {
//    	
//    	return $http.get(urlBase+'/getAll/');
//    };
//
//    return AvvisiService;	
//	
//}]);


app.factory('AvvisiService', ['$http','$q', function ($http,$q) {
	
	var urlBase = 'http://localhost:8080/SpringBootCRUDApp/avvisi';
    var AvvisiService = {};

    AvvisiService.getAll = function () {
    	var def = $q.defer();
    	    	
    	$http.get(urlBase+'/getAll/')
	    	.success(function(data) {
	            def.resolve(data);
	        })
	        .error(function() {
	            def.reject("Errore durante il recupero degli avvisi");
	        });
    	
    	return def.promise;
    };

    return AvvisiService;	
	
}]);