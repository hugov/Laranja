/**
 * 
 */
package br.com.decimal.laranja.entity;

import java.io.Serializable;

/**
 * @author vitor.oliveira
 *
 */
public class Itinerario implements Serializable {

	private static final long serialVersionUID = 4481934490324212456L;
	private Long idItinerario;
	private String descricao;
	private Double latitude;
	private Double longitude;
	private Long status;

	public Long getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(Long idItinerario) {
		this.idItinerario = idItinerario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
