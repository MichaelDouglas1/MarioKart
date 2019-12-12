mariokart.factory("cadastroService",cadastroService);

cadastroService.$inject = [ "$http" ];

function cadastroService($http){
	const baseUrl = 'http://localhost:8080/mario-kart-desafio-final/jogador';
	
	const self = this;
	self.jogador = null;
	
	var _cadastrarJogador = function(dadosCadastro) {
		
		let cripto = {
			    nickname: dadosCadastro.nickname,
			    senha: btoa(dadosCadastro.senha),
			    IdPersonagem: dadosCadastro.IdPersonagem
			}
		
		return $http.post(baseUrl, cripto)
	};
	
		return {
			cadastrarJogador: _cadastrarJogador
		};
	
}