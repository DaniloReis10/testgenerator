package javabeans;

/**
 * Classe responsavel da organizaçao das questoes dissertativas através de pergunta, resposta e chave estrageira da classe topico
 * @author Fernando Matheus
 *
 */

public class QuestaoDissertativa {
	
	
	private String pergunta;
	private String resposta;
	private int Topico_idTopico;
	
	public QuestaoDissertativa(String pergunta, String resposta, int Topico_idTopico){
		
		this.pergunta = pergunta;		
		this.resposta = resposta;
		this.Topico_idTopico = Topico_idTopico;
		
	}

	

	public int getTopico_idTopico() {
		return Topico_idTopico;
	}



	public void setTopico_idTopico(int topico_idTopico) {
		Topico_idTopico = topico_idTopico;
	}



	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	

}
