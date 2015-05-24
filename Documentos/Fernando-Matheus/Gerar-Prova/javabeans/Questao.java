package javabeans;

public class Questao {
	
	private int idQuestao;
	private int tipo; // Tipo 1: Questao objetiva || Tipo 2: Questao V ou F || Tipo 3: Questao discursiva
	private String pergunta;
	private String item_a;
	private String item_b;
	private String item_c;
	private String item_d;
	private String item_1_VF;
	private String item_2_VF;
	private String item_3_VF;
	private String item_4_VF;
	private String resposta_item;
	private String resposta_VF;
	private String resposta_texto;
	private int Topico_idTopico;
	
	public Questao(int idQuestao, int tipo, String pergunta, String item_a, String item_b, String item_c, String item_d,
			String item_1_VF, String item_2_VF, String item_3_VF, String item_4_VF, String resposta_item, String resposta_VF,
			String resposta_texto, int Topico_idTopico){
		
		this.idQuestao=idQuestao;
		this.tipo=tipo;
		this.pergunta = pergunta;
		this.item_a=item_a;
		this.item_b=item_b;
		this.item_c=item_c;
		this.item_d=item_d;
		this.item_1_VF = item_1_VF;
		this.item_2_VF = item_2_VF;
		this.item_3_VF = item_3_VF;
		this.item_4_VF = item_4_VF;
		this.resposta_item =resposta_item;
		this.resposta_VF= resposta_VF;
		this.resposta_texto = resposta_texto;
		this.Topico_idTopico=Topico_idTopico;
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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

	public String getResposta_item() {
		return resposta_item;
	}

	public void setResposta_item(String resposta_item) {
		this.resposta_item = resposta_item;
	}

	public String getResposta_VF() {
		return resposta_VF;
	}

	public void setResposta_VF(String resposta_VF) {
		this.resposta_VF = resposta_VF;
	}

	public String getResposta_texto() {
		return resposta_texto;
	}

	public void setResposta_texto(String resposta_texto) {
		this.resposta_texto = resposta_texto;
	}

	public int getTopico_idTopico() {
		return Topico_idTopico;
	}

	public void setTopico_idTopico(int topico_idTopico) {
		Topico_idTopico = topico_idTopico;
	}
	
	
	
	
	
}
