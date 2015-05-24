package javabeans;

public class Disciplina {
	
	private int idDisciplina;
	private String nome;
	
	public Disciplina(int idDisciplina, String nome){
		this.idDisciplina=idDisciplina;
		this.nome=nome;
		
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
