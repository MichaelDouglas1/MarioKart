angular.module("mariokart").controller("CorridaController", CorridaController);

PersonagemController.$inject = [ '$scope', 'CorridaService','loginService' ];

function CorridaController($scope, CorridaService, loginService) {
	var vm = this;
	vm.service = CorridaService;
	vm.resultado = {};
	vm.corridaFinalizou = false;
	vm.jogadorLogado = loginService.jogador;
	vm.checarVitoria = function (){
		console.log(vm.jogadorLogado);
		return vm.resultado.idPersonagem == vm.jogadorLogado.personagem.id ? 'Parabens você venceu' : 'Sinto muito, você perdeu';
	}
	
	

	vm.iniciarCorrida = function() {
		vm.service.iniciarCorrida().success(function(data) {
			vm.resultado = data;
			console.log(vm.resultado);
			vm.checarVitoria();
			vm.corridaFinalizou = true;
		}).error(function(data, status) {
			vm.message = "Aconteceu um problema: " + data;
			console.log(data);
		});
	};
}