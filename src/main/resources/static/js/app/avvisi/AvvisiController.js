'use strict';

app.controller('AvvisiController', function ($scope, AvvisiService) {
	
    $scope.avvisi;
    $scope.status;
    getAll();

   
//    
//    function getAll() {
//    	AvvisiService.getAll()
//            .success(function (avv) {
//                $scope.avvisi = avv;                              
//                
//            })
//            .error(function (error) {
//                $scope.status = 'Non è stato possibile caricare gli avvisi: ' + error.message;
//            });
//    	   	
//    }
//

    
    function getAll() {
    	AvvisiService.getAll()
            .then(function (avv) {           
                $scope.avvisi = avv;                              
                
            },
            function(data) {            	
                console.log(data);
            });  
    	
     	
    }   
    

});