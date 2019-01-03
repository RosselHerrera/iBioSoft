package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOAcceso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idacc;
	private int accnumero;
	private String accsistema;
	private String accrut;
	private String accrazonsocial;
	private String accfono;
	private String accfechavigencia;
	private String accfiller;
	
	
	public int getIdacc() {
		return idacc;
	}
	public void setIdacc(int idacc) {
		this.idacc = idacc;
	}
	
	public int getAccnumero() {
		return accnumero;
	}
	public void setAccnumero(int accnumero) {
		this.accnumero = accnumero;
	}
	
	public String getAccsistema() {
		return accsistema;
	}
	public void setAccsistema(String accsistema) {
		this.accsistema = accsistema;
	}
	
	public String getAccrut() {
		return accrut;
	}
	public void setAccrut(String accrut) {
		this.accrut = accrut;
	}
	
	public String getAccrazonsocial() {
		return accrazonsocial;
	}
	public void setAccrazonsocial(String accrazonsocial) {
		this.accrazonsocial = accrazonsocial;
	}
	
	public String getAccfono() {
		return accfono;
	}
	public void setAccfono(String accfono) {
		this.accfono = accfono;
	}
	
	public String getAccfechavigencia() {
		return accfechavigencia;
	}
	public void setAccfechavigencia(String accfechavigencia) {
		this.accfechavigencia = accfechavigencia;
	}
	
	public String getAccfiller() {
		return accfiller;
	}
	public void setAccfiller(String accfiller) {
		this.accfiller = accfiller;
	}
	
}
