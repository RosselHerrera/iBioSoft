package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOLaboratorio  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idnumcarga;
	private int idmov;
	private String fechalab;
	private String einumdoc;
	private String operador;
	private int oc;
	private String tipolena;
	private String cantidad;
	private String obsevaciones;
	private String filler;
	/* -------------------------------------------- */
	public int getIdnumcarga() {
		return idnumcarga;
	}
	public void setIdnumcarga(int idnumcarga) {
		this.idnumcarga = idnumcarga;
	}
	/* -------------------------------------------- */
	public int getIdmov() {
		return idmov;
	}
	public void setIdmov(int idmov) {
		this.idmov = idmov;
	}
	/* -------------------------------------------- */
	public String getFechalab() {
		return fechalab;
	}
	public void setFechalab(String fechalab) {
		this.fechalab = fechalab;
	}
	/* -------------------------------------------- */
	public String getEinumdoc() {
		return einumdoc;
	}
	public void setEinumdoc(String einumdoc) {
		this.einumdoc = einumdoc;
	}
	/* -------------------------------------------- */
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	/* -------------------------------------------- */
	public int getOc() {
		return oc;
	}
	public void setOc(int oc) {
		this.oc = oc;
	}
	/* -------------------------------------------- */
	public String getTipolena() {
		return tipolena;
	}
	public void setTipolena(String tipolena) {
		this.tipolena = tipolena;
	}
	/* -------------------------------------------- */
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	/* -------------------------------------------- */
	public String getObsevaciones() {
		return obsevaciones;
	}
	public void setObsevaciones(String obsevaciones) {
		this.obsevaciones = obsevaciones;
	}
	/* fillerJASON */
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	

}
