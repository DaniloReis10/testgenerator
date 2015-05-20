package model;

import java.io.Serializable;

public class Opcao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6905308615934414930L;

	private Integer id;
	private String enunciado;
	private Integer id_questao;
	private String resposta;
	private Integer status;
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
	public Integer getId_questao() {
		return id_questao;
	}
	public void setId_questao(Integer id_questao) {
		this.id_questao = id_questao;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_questao == null) ? 0 : id_questao.hashCode());
		result = prime * result
				+ ((resposta == null) ? 0 : resposta.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Opcao other = (Opcao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_questao == null) {
			if (other.id_questao != null)
				return false;
		} else if (!id_questao.equals(other.id_questao))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	
}
