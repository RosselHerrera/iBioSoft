package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOconvenios implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ideiconvenios;
	private String eirut;
	private String eirazonsocial;
	private String eiemail;
	private String eifono;
	private String eifechavigencia;
	private String eimensaje;
	
	public int getIdeiconvenios() {
		return ideiconvenios;
	}
	public void setIdeiconvenios(int ideiconvenios) {
		this.ideiconvenios = ideiconvenios;
	}
	
	public String getEirut() {
		return eirut;
	}
	public void setEirut(String eirut) {
		this.eirut = eirut;
	}
	
	public String getEirazonsocial() {
		return eirazonsocial;
	}
	public void setEirazonsocial(String eirazonsocial) {
		this.eirazonsocial = eirazonsocial;
	}
	
	public String getEiemail() {
		return eiemail;
	}
	public void setEiemail(String eiemail) {
		this.eiemail = eiemail;
	}
	
	public String getEifono() {
		return eifono;
	}
	public void setEifono(String eifono) {
		this.eifono = eifono;
	}
	
	public String getEifechavigencia() {
		return eifechavigencia;
	}
	public void setEifechavigencia(String eifechavigencia) {
		this.eifechavigencia = eifechavigencia;
	}
	
	public String getEimensaje() {
		return eimensaje;
	}
	public void setEimensaje(String eimensaje) {
		this.eimensaje = eimensaje;
	}
	
	
	

}
