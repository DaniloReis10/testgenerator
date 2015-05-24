package javabeans;

public class Topico {
	
	private int idTopico;
	private String nome;
	private int Disciplina_idDisciplina;
	
	public Topico(int idTopico, String nome, int Disciplina_idDisciplina){
		this.idTopico=idTopico;
		this.nome=nome;
		this.Disciplina_idDisciplina= Disciplina_idDisciplina;
	}

	public int getDisciplina_idDisciplina() {
		return Disciplina_idDisciplina;
	}

	public void setDisciplina_idDisciplina(int disciplina_idDisciplina) {
		Disciplina_idDisciplina = disciplina_idDisciplina;
	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
