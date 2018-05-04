var app = angular.module('crudApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: '<a class="vglnk" href="http://localhost:8080/SpringBootCRUDApp" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>SpringBootCRUDApp</span></a>',
    USER_SERVICE_API : '<a class="vglnk" href="http://localhost:8080/SpringBootCRUDApp/api/user/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>SpringBootCRUDApp</span><span>/</span><span>api</span><span>/</span><span>user</span><span>/</span></a>'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);