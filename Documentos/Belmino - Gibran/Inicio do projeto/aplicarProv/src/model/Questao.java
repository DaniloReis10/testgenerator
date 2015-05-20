package model;

import java.io.Serializable;
import java.util.List;

public class Questao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String enunciado;
	private String tipo;
	private Integer id_topico;
	private List<Opcao> opcoes;
	/**
	 * @return the opcoes
	 */
	public List<Opcao> getOpcoes() {
		return opcoes;
	}
	/**
	 * @param opcoes the opcoes to set
	 */
	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getId_topico() {
		return id_topico;
	}
	public void setId_topico(Integer id_topico) {
		this.id_topico = id_topico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_topico == null) ? 0 : id_topico.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_topico == null) {
			if (other.id_topico != null)
				return false;
		} else if (!id_topico.equals(other.id_topico))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	

}