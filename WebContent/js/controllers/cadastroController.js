angular.module("mariokart").controller("cadastroController",
        cadastroController);

cadastroController.$inject = [ '$scope', '$location', 'cadastroService' ];

function cadastroController($scope, $location, cadastroService){
	const self = this;
	self.dadosCadastro = {
			nickname: null,
			senha: null,
			IdPersonagem: null
	};
	self.service = cadastroService;
	
	self.msg="";
	
	self.personagemEscolhido = null;	
	
	self.cadastrar = function(){

		self.dadosCadastro.IdPersonagem = self.personagemEscolhido.id;
		
		self.service.cadastrarJogador(self.dadosCadastro).then(
				response => {if(response.status==201){
					$location.path("/login")
				}},
				error => {
					console.log(error);
					self.msg = error.mensagem;
				}
		)
		
		
	}
	
}