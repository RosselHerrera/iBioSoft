package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOInstituciones implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private	int	ididoopp ;
	private	String nombreoopp; 
	private	int codopp;
	private	String sector;
	private	String vigencia;
	private	String filler;
	
	public int getIdidoopp() {
		return ididoopp;
	}
	public void setIdidoopp(int ididoopp) {
		this.ididoopp = ididoopp;
	}
	public String getNombreoopp() {
		return nombreoopp;
	}
	public void setNombreoopp(String nombreoopp) {
		this.nombreoopp = nombreoopp;
	}
	public int getCodopp() {
		return codopp;
	}
	public void setCodopp(int codopp) {
		this.codopp = codopp;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	



}
