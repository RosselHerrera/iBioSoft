package cl.energiainteligente.dto;

import java.io.Serializable;

public class DTOBoletas implements Serializable {
	
	/**
	 * BOLETAS 06.10.2018
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bid; 
	private int bboleta;
	private String bcodInstitucion;
	private int bneto;
	private int biva;
	private int btotalBoleta;
	private String bfiller;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBboleta() {
		return bboleta;
	}
	public void setBboleta(int bboleta) {
		this.bboleta = bboleta;
	}
	public String getBcodInstitucion() {
		return bcodInstitucion;
	}
	public void setBcodInstitucion(String bcodInstitucion) {
		this.bcodInstitucion = bcodInstitucion;
	}
	public int getBneto() {
		return bneto;
	}
	public void setBneto(int bneto) {
		this.bneto = bneto;
	}
	public int getBiva() {
		return biva;
	}
	public void setBiva(int biva) {
		this.biva = biva;
	}
	public int getBtotalBoleta() {
		return btotalBoleta;
	}
	public void setBtotalBoleta(int btotalBoleta) {
		this.btotalBoleta = btotalBoleta;
	}
	public String getBfiller() {
		return bfiller;
	}
	public void setBfiller(String bfiller) {
		this.bfiller = bfiller;
	}
	
	
	
	
	
	

}
