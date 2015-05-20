	var paginaAtual = 1;
	var totalPagina = 4;

    window.onload = function(){
    	$("#q1").show();
        var a = document.getElementsByTagName("a")[0];
            if(a.className.indexOf("finalizar") > 0){
            a.onclick = function(){
                var yes = confirm('Tem certeza que deseja finalizar?');
                if (yes){
                    //a.href = "resultado.html";
                    return true;
                }
            }
        }

	
		$("#btPosterior").click(function(){
		    if(paginaAtual < totalPagina){
			$("#q"+paginaAtual).hide();
			paginaAtual++;
			$("#q"+paginaAtual).show();
		    }
		    if(paginaAtual > 1){
			$("#btAnterior").prop("disabled", false);
		    }
		    if(paginaAtual == totalPagina){
			$("#btPosterior").prop("disabled", true);
		    }
		    
		});
		$("#btAnterior").click(function(){
		    if(paginaAtual > 1){
			$("#q"+paginaAtual).hide();
			paginaAtual--;
			$("#q"+paginaAtual).show();
		    }
		    if(paginaAtual < totalPagina){
			$("#btPosterior").prop("disabled", false);
		    }
		    if(paginaAtual == 1){
			$("#btAnterior").prop("disabled", true);
		    }
		    
		});
    }