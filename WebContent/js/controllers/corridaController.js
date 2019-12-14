angular.module("mariokart").controller("CorridaController", CorridaController);

PersonagemController.$inject = [ '$scope','$location', 'CorridaService','loginService' ];



function CorridaController($scope, $location ,CorridaService, loginService) {

	self.irTelaLogin = function(){
		$location.path("/login");
	}

	
	var vm = this;
	vm.service = CorridaService;
	vm.resultado = {};
	vm.corridaFinalizou = false;
	vm.jogadorLogado = loginService.jogador;
	vm.checarVitoria = function (){
		return vm.resultado.idVencedor == vm.jogadorLogado.personagem.id ? 'Parabens você venceu' : 'Sinto muito, você perdeu';
	}
	
	

	vm.iniciarCorrida = function() {
		vm.service.iniciarCorrida().success(function(data) {
			vm.resultado = data;
			vm.checarVitoria();
			vm.corridaFinalizou = true;
		}).error(function(data, status) {
			vm.message = "Aconteceu um problema: " + data;
			console.log(data);
		});
	};
	
}