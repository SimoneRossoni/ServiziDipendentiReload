app.factory('AuthInterceptor', [function() {  
    return {
        'request': function(config) {
            config.headers = config.headers || {};
            var encodedString = btoa("user:c72e3293-23f0-49e4-a492-5be00ad857f71");
            config.headers.Authorization = 'Basic '+encodedString;
           return config;
        }
    };
}]);