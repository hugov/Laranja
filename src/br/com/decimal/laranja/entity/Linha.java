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

	private Long contaId;
	private Long linhaId;
	private Long status;

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	public Long getLinhaId() {
		return linhaId;
	}

	public void setLinhaId(Long linhaId) {
		this.linhaId = linhaId;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
