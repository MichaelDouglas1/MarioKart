angular.module("mariokart").factory("CorridaService", function ($http) {
	var baseUrl = 'http://localhost:8080/mario-kart-desafio-final/corrida';
	var _iniciarCorrida = function () {
		return $http.get(baseUrl);
	};
	
	//na hora de cadastrar o personagem a service estava abrindo no lugar errado, estava buscando _iniciarCorrida ou inves de _getPersonagem
	var baseUrl2 = 'http://localhost:8080/mario-kart-desafio-final/personagem';
	var _getPersonagens = function () {
		return $http.get(baseUrl2);
	};

	return {
		iniciarCorrida: _iniciarCorrida,
		getPersonagens: _getPersonagens
	};	
});