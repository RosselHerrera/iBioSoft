package cl.energiainteligente.dto;

import java.io.Serializable;

/**
 * @author Lozoronca
 *
 */
public class DTOMovimientos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ideiMovfecha;
	private String eicodigoP;
	private String eitipodoc;
	private String eirut;
	private String einumdoc;
	private String eifechamovimiento;
	private String eiunidadesP;
	private String eifiller;
	private int eihumedad;
	private int eidistancia;
	private String eitransporte;
	private int eivalor;
	private int eivaloragregado;
	
	public int getIdeiMovfecha() {
		return ideiMovfecha;
	}
	public void setIdeiMovfecha(int ideiMovfecha) {
		this.ideiMovfecha = ideiMovfecha;
	}
	
	public String getEicodigoP() {
		return eicodigoP;
	}
	public void setEicodigoP(String eicodigoP) {
		this.eicodigoP = eicodigoP;
	}
	
	public String getEitipodoc() {
		return eitipodoc;
	}
	public void setEitipodoc(String eitipodoc) {
		this.eitipodoc = eitipodoc;
	}
	
	public String getEirut() {
		return eirut;
	}
	public void setEirut(String eirut) {
		this.eirut = eirut;
	}
	
	public String getEinumdoc() {
		return einumdoc;
	}
	public void setEinumdoc(String einumdoc) {
		this.einumdoc = einumdoc;
	}
	
	public String getEifechamovimiento() {
		return eifechamovimiento;
	}
	public void setEifechamovimiento(String eifechamovimiento) {
		this.eifechamovimiento = eifechamovimiento;
	}
	
	public String getEiunidadesP() {
		return eiunidadesP;
	}
	public void setEiunidadesP(String eiunidadesP) {
		this.eiunidadesP = eiunidadesP;
	}
	
	public String getEifiller() {
		return eifiller;
	}
	public void setEifiller(String eifiller) {
		this.eifiller = eifiller;
	}	
	
	public int getEihumedad() {
		return eihumedad;
	}
	public void setEihumedad(int eihumedad) {
		this.eihumedad = eihumedad;
	}
	
	public int getEidistancia() {
		return eidistancia;
	}
	public void setEidistancia(int eidistancia) {
		this.eidistancia = eidistancia;
	}
	
	public String getEitransporte() {
		return eitransporte;
	}
	public void setEitransporte(String eitransporte) {
		this.eitransporte = eitransporte;
	}

	public int getEivalor() {
		return eivalor;
	}
	public void setEivalor(int eivalor) {
		this.eivalor = eivalor;
	}
	
	public int getEivaloragregado() {
		return eivaloragregado;
	}
	public void setEivaloragregado(int eivaloragregado) {
		this.eivaloragregado = eivaloragregado;
	}
}
