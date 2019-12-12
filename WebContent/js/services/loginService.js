mariokart.factory("loginService", loginService);

loginService.$inject = [ "$http" ];

function loginService($http) {
    const baseUrl = 'http://localhost:8080/mario-kart-desafio-final/jogador/logar';
    
    const self = this;
    self.jogador = null;
    
    var _logar = function(dadosLogin) {
    	let criptoDoLogin = {
    		    nickname: dadosLogin.nickname,
    		    senha: btoa(dadosLogin.senha)
    		}
    	
        return $http.post(baseUrl, criptoDoLogin);
    };

    return {
        logar: _logar
    };

}