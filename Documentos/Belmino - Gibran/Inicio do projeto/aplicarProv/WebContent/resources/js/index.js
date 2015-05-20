$(document).ready(function(){
		$(".form-excluir").on('submit', function(e){
		e.preventDefault();
		var yes = confirm('Tem certeza que deseja deletar este registro?');
		if (yes) {
			e.target.submit();
		}else{
			e.preventDefault();
		}
	});
});