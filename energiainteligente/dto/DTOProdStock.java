package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOProdStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idstk; 
	private String stkcodigoP;
	private String stkdescripcion;
	private String stkfiller;
	private int stkprecio;
	private int stkP;
	
	public int getIdstk() {
		return idstk;
	}
	public void setIdstk(int idstk) {
		this.idstk = idstk;
	}
	
	public String getStkcodigoP() {
		return stkcodigoP;
	}
	public void setStkcodigoP(String stkcodigoP) {
		this.stkcodigoP = stkcodigoP;
	}
	
	public String getStkdescripcion() {
		return stkdescripcion;
	}
	public void setStkdescripcion(String stkdescripcion) {
		this.stkdescripcion = stkdescripcion;
	}
	
	public String getStkfiller() {
		return stkfiller;
	}
	public void setStkfiller(String stkfiller) {
		this.stkfiller = stkfiller;
	}
	
	public int getStkprecio() {
		return stkprecio;
	}
	public void setStkprecio(int stkprecio) {
		this.stkprecio = stkprecio;
	}
	
	public int getStkP() {
		return stkP;
	}
	public void setStkP(int stkP) {
		this.stkP = stkP;
	}
	

}
