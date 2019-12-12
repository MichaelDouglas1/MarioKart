mariokart.config(Config);

Config.$inject = [ "$routeProvider" ];

function Config($routeProvider) {
    $routeProvider.when("/", {
    	templateUrl : "js/paginas/login.html"
    }).when("/cadastro",{
    	templateUrl : "js/paginas/cadastro.html"
    }).otherwise({
        redirectTo : "/"
    });
}