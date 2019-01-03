package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOHumedad implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Id;
	private String codAndamio;
	private String codBin;
	private String humedad;
	private String fechaRegistro;
	private String descripcion;
	private String salida;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getCodAndamio() {
		return codAndamio;
	}
	
	public void setCodAndamio(String codAndamio) {
		this.codAndamio = codAndamio;
	}
	
	public String getCodBin() {
		return codBin;
	}
	
	public void setCodBin(String codBin) {
		this.codBin = codBin;
	}
	
	public String getHumedad() {
		return humedad;
	}
	
	public void setHumedad(String humedad) {
		this.humedad = humedad;
	}
	
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getSalida() {
		return salida;
	}
	
	public void setSalida(String salida) {
		this.salida = salida;
	}
	
}
