var MainController =  ['$scope','$rootScope','$state','$sessionStorage', 'context', function($scope, $rootScope, $state, $sessionStorage, context) {
	
	$scope.$storage = $sessionStorage;
	
	$scope.getSession = function() {
		return $scope.$storage.session;
	};
	
	$scope.login = function() {
		$scope.$storage.session = { 'username' : 'test' };
		$state.go('dashboard');
	};
	
	$scope.logout = function() {
		$scope.$storage.session = null;
		$state.go('welcome');
	};
	
	$scope.goHome = function() {
		if ($scope.getSession() == null) {
			$state.go('welcome');
		} else {
			$state.go('dashboard');
		}
	}
	
	$scope.context = context;
	
	$scope.footerText = '© ' + new Date().getFullYear() + ' EI Web App ';
	
	$rootScope.$state = $state;
	
	$rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
		var requireLogin = toState.data.requireLogin;

		if (requireLogin && $scope.getSession() == null) {
			event.preventDefault();
			$state.go('landing');
		}
	});
}];


