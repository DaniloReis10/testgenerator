package javabeans;

/**
 * Classe responsavel pela organizaçao das questoes objetivas por pergunta, itens, resposta do mesmo e a chave estrangeira da classe topico.
 *  * @author Fernando Matheus
 *
 */

public class QuestaoObjetiva {
	
	
	private String pergunta;
	private String item_a;
	private String item_b;
	private String item_c;
	private String item_d;
	private String resposta;
	private int Topico_idTopico;
	
	public QuestaoObjetiva(String pergunta, String item_a, String item_b, String item_c, String item_d, String resposta, int Topico_idTopico){
		
		this.pergunta = pergunta;
		this.item_a = item_a;
		this.item_b = item_b;
		this.item_c = item_c;
		this.item_d = item_d;
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

	public String getItem_a() {
		return item_a;
	}

	public void setItem_a(String item_a) {
		this.item_a = item_a;
	}

	public String getItem_b() {
		return item_b;
	}

	public void setItem_b(String item_b) {
		this.item_b = item_b;
	}

	public String getItem_c() {
		return item_c;
	}

	public void setItem_c(String item_c) {
		this.item_c = item_c;
	}

	public String getItem_d() {
		return item_d;
	}

	public void setItem_d(String item_d) {
		this.item_d = item_d;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	


}
