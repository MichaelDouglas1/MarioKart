angular.module("mariokart").factory("CorridaService", function ($http) {
	var baseUrl = 'http://localhost:8080/mario-kart-desafio-final/corrida';
	var _iniciarCorrida = function () {
		return $http.get(baseUrl);
	};

	return {
		iniciarCorrida: _iniciarCorrida
	};	
});