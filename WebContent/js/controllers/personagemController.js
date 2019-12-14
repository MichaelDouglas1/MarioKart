angular.module("mariokart").controller("PersonagemController",
		PersonagemController);

PersonagemController.$inject = [ '$scope', 'PersonagemService' ];

function PersonagemController($scope, PersonagemService) {
	var vp = this;
	vp.service = PersonagemService;
	vp.personagens = [];

	vp.init = function() {
		vp.carregarPersonagens();
	};

	vp.carregarPersonagens = function() {
		console.log(vp.service);
		vp.service.getPersonagens().success(function(data) {
			vp.personagens = data;
		}).error(function(data, status) {
			vp.message = "Aconteceu um problema: " + data;
		});
	};
}