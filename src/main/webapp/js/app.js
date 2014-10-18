angular.module('mobitrg', [ 'ui.bootstrap', 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
				templateUrl : 'partials/home.html',
			}).otherwise({
				redirectTo : '/home'
			});
		} ]);