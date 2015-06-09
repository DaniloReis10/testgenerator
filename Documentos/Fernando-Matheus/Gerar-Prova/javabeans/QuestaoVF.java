package javabeans;

/**
 * Classe responsavel pelo controle das questoes verdadeiras e falsas por pergunta, itens, resposta de cada item, e a chave estrangeira na classe topico.
 * @author Fernando Matheus
 *
 */

public class QuestaoVF {
	
	
	private String pergunta;
	private String item_1_VF;
	private String item_2_VF;
	private String item_3_VF;
	private String item_4_VF;
	private String resposta_1;
	private String resposta_2;
	private String resposta_3;
	private String resposta_4;
	private int Topico_idTopico;
	
	public QuestaoVF(String pergunta, String item_1_VF, String item_2_VF, String item_3_VF, String item_4_VF,
			String resposta_1, String resposta_2, String resposta_3, String resposta_4, int Topico_idTopico){
		
		this.pergunta = pergunta;
		this.item_1_VF = item_1_VF;
		this.item_2_VF = item_2_VF;
		this.item_3_VF = item_3_VF;
		this.item_4_VF = item_4_VF;
		this.resposta_1 = resposta_1;
		this.resposta_2 = resposta_2;
		this.resposta_3 = resposta_3;
		this.resposta_4 = resposta_4;
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

	public String getItem_1_VF() {
		return item_1_VF;
	}

	public void setItem_1_VF(String item_1_VF) {
		this.item_1_VF = item_1_VF;
	}

	public String getItem_2_VF() {
		return item_2_VF;
	}

	public void setItem_2_VF(String item_2_VF) {
		this.item_2_VF = item_2_VF;
	}

	public String getItem_3_VF() {
		return item_3_VF;
	}

	public void setItem_3_VF(String item_3_VF) {
		this.item_3_VF = item_3_VF;
	}

	public String getItem_4_VF() {
		return item_4_VF;
	}

	public void setItem_4_VF(String item_4_VF) {
		this.item_4_VF = item_4_VF;
	}



	public String getResposta_1() {
		return resposta_1;
	}



	public void setResposta_1(String resposta_1) {
		this.resposta_1 = resposta_1;
	}



	public String getResposta_2() {
		return resposta_2;
	}



	public void setResposta_2(String resposta_2) {
		this.resposta_2 = resposta_2;
	}



	public String getResposta_3() {
		return resposta_3;
	}



	public void setResposta_3(String resposta_3) {
		this.resposta_3 = resposta_3;
	}



	public String getResposta_4() {
		return resposta_4;
	}



	public void setResposta_4(String resposta_4) {
		this.resposta_4 = resposta_4;
	}


	
	

}
