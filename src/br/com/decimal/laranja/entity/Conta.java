/**
 * 
 */
package br.com.decimal.laranja.entity;

import java.io.Serializable;

/**
 * Classe responsavel pelo gerenciamento das contas dos clientes.
 * 
 * @author vitor.oliveira
 *
 */
public class Conta implements Serializable {

	private Long id;
	private Long status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
