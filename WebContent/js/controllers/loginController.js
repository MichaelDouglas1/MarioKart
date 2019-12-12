angular.module("mariokart").controller("loginController",
        loginController);

loginController.$inject = [ '$scope','$location','loginService' ];

function loginController($scope, $location ,loginService) {	
	const self = this;
	self.dadosLogin = {
	    nickname: '',
	    senha: ''
	};
	self.service= loginService;
	
	self.msg ="";
    
	
	self.logar = function() {		
		self.service.logar(self.dadosLogin).success(function(data) {
            console.log(data);
        }).error(function(data, status) {
            console.log(data);
            self.msg = data.mensagem;
        });
	}
	
	self.irTelaCadastro = function(){
		$location.path("/cadastro");
	}
}