angular.module('mobitrg', [ 'ui.bootstrap', 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
				templateUrl : 'partials/home.html',
			}).$routeProvider.when('/user/register', {
				templateUrl : 'partials/register.html',
			}).otherwise({
				redirectTo : '/home'
			});
		} ]);