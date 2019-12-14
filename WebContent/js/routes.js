mariokart.config(Config);

Config.$inject = [ "$routeProvider" ];

function Config($routeProvider) {
    $routeProvider.when("/login", {
    	templateUrl : "js/paginas/login.html"
    }).when("/cadastro",{
    	templateUrl : "js/paginas/cadastro.html"
    }).when("/corrida",{
    	templateUrl : "js/paginas/corrida.html"
    }).otherwise({
        redirectTo : "/login"
    });
}