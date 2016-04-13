/**
 * 
 */
package br.com.decimal.laranja.entity;

import java.io.Serializable;

/**
 * @author vitor.oliveira
 *
 */
public class Linha implements Serializable {

	private static final long serialVersionUID = -292187744191157501L;
	private Long idConta;
	private Long idLinha;
	private String descricao;
	private Long tamanhoLinha;
	private Long status;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Long getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(Long idLinha) {
		this.idLinha = idLinha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTamanhoLinha() {
		return tamanhoLinha;
	}

	public void setTamanhoLinha(Long tamanhoLinha) {
		this.tamanhoLinha = tamanhoLinha;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
