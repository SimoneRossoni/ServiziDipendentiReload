'use strict';

var UtilFilter = angular.module('UtilFilter', [])
.filter('convertiByteArrayInString', function () {
    return function (items) { 
    	return atob(items);
    };
});