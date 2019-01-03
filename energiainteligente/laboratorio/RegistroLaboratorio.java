package cl.energiainteligente.laboratorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cl.energiainteligente.dto.DTOMovimientos;
import cl.escritorio.persistencia.DBConectJDBC;


/**
* Clase Helper para mantener Procedimientos Laboratorio
* 
* @author http://rosseltech.cl
* @version 1.0
* @since SEP 2018
 *
 */
public class RegistroLaboratorio {
	
	/**
	 * Método Identidad
	 * 
	 * @return int
	 */
	public int identidad (String tabla){
		Connection dbsql = null;
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="select COUNT(*) from " + tabla;
			dbsql = new DBConectJDBC().getConection();
			PreparedStatement pStmt = dbsql.prepareStatement(sql);
			Ret = pStmt.executeQuery();
			if(Ret.next()){
			  ret = Ret.getInt(1);
			} else {
			  ret = 0;	
			}
			Ret.close();
			pStmt.close();
		} catch (Exception e){
			System.out.println("ERROR: Fallo COUNT(*)");
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Lista Movimientos EnergiaIntelegente
	 * 
	 * Sobrecarga del método por Tipo Documento 
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 * 
	 */
	public ArrayList<DTOMovimientos> ListaMovimientos(int numdoc)  throws SQLException, IOException {
	Connection dbcon = null;	
	ResultSet resultado = null;
	DTOMovimientos movimiento;
		/* ------------------------------------------------------------------------ */
		ArrayList<DTOMovimientos> listadoMovimientos = new ArrayList<DTOMovimientos>();	
		/* ------------------------------------------------------------------------- */
		try {
			dbcon = new DBConectJDBC().getConection();
			final String sql = "SELECT ideistkMovfechaCV, "
										+ "eistkcodigoP, "
											+ "eistktipodoc, "
												+ "eistkrut, "
													+ "eistknumdoc, "
														+ "eistkfechamovimiento, "
														    + "eistkunidadesP, "
															    + "eistkfiller, "
															    	+ "humedad, "
															    		+ "distancia, "
															    			+ "transporte, "
															    				+ "valor "
															    					+ "FROM eistkmovfechacv "
																			   	  		+	" WHERE `ideistkMovfechaCV` ='" + numdoc + "'"  
																			   	  			+ " ORDER BY eistkfechamovimiento desc";
		    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
			resultado = pStmt.executeQuery();
			while (resultado.next()) {
	        	/* --------------------- */
				movimiento = new DTOMovimientos();
	        	/* --------------------- */
				movimiento.setIdeiMovfecha(resultado.getInt(1));
				movimiento.setEicodigoP(resultado.getString(2));
				movimiento.setEitipodoc(resultado.getString(3));
				movimiento.setEirut(resultado.getString(4));
				movimiento.setEinumdoc(resultado.getString(5));
				movimiento.setEifechamovimiento(resultado.getString(6));
				movimiento.setEiunidadesP(resultado.getString(7));
				movimiento.setEifiller(resultado.getString(8));
				movimiento.setEihumedad(resultado.getInt(9));
				movimiento.setEidistancia(resultado.getInt(10));
				movimiento.setEitransporte(resultado.getString(11));
				movimiento.setEivalor(resultado.getInt(12));
	        	/* --------------------- */
				listadoMovimientos.add(movimiento);
	        	/* --------------------- */
		    }
			resultado.close();       //liberamos resultados
	        pStmt.close();           //liberamos recursos
		}catch (Exception e) {
			System.out.println("ERROR: Fallo al conectar con JDBC driver.");
			e.printStackTrace();
		}finally{
			if (dbcon != null) dbcon.close();
		}
		return listadoMovimientos;	
	}
	
	/**
	 * Inserta Movimiento Traceable 
	 * Laboratorio iLenia
	 * 
	 * @param id
	 * @param idmov
	 * @param labfecha
	 * @param numdoc
	 * @param operador
	 * @param ordencompra
	 * @param tipolenacarga
	 * @param cantidad
	 * @param observaciones
	 * @param filler
	 * @return int
	 * @throws SQLException
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 */
	public int GrabaMovimientoLab (int id, 
									 int idmov, 
										String labfecha, 
										  String numdoc,
										     String operador,
												int ordencompra, 
												  String tipolenacarga,
												    String cantidad,
													  String observaciones,
													    String filler)  throws SQLException {
		/* --------------------------------------------------------------------------------- */
		Connection dbsql = null;
		@SuppressWarnings("unused")
		ResultSet resultado = null;
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		
		/* registro laboratorio */
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* ------------------------------------ */
			String query = "INSERT INTO `orgdata`.`eistklaboratorio` (idnumcarga, "
																	+ "idmov, "
																	 + "labfecha, "
																	  + "numdoc, "
																	   + "operador, "
																	    + "ordencompra, "
																	     + "tipolenacarga, "
																	      + "cantidad, "
																	       + "observaciones, "
																	        + "filler) "  												
								  +	"VALUES (" + id + "," + 
												  idmov + ", '" + 
												   labfecha + "', ' " + 
												    numdoc + "', '" + 
												     operador + "', " +
												      ordencompra + ", '" +
												       tipolenacarga + "', '" +
												        cantidad + "', '" +
												         observaciones + "', '" +
												          filler + "')";
			stmt.executeUpdate(query);
			stmt.close();
			/* -------------------------------------------------------------------------------------------- */
			
			
			/* --- */
			return 1;
			/* --- */	
		} catch (Exception e) {
			System.out.println("ERROR: Fallo Inserción al conectar con JDBC driver.");
			e.printStackTrace();
			/* --- */
			return 0;
			/* --- */
		} finally{
			if (dbsql != null) dbsql.close();
		}	
	}

}
