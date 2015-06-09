function validaQuantidade(){
	if(document.form.quantidadeQuestoes.value==""){
		alert("Preecha o campo de quantidade de questões!");
		document.form.quantidadeQuestoes.focus();
		return false;
	}
}

function validaDisciplina(){
	if(document.formulario.disciplina.value=""){
		alert("Digite uma disciplina para seguir.");
		document.formulario.disciplina.focus();
		return false;
	}
}
