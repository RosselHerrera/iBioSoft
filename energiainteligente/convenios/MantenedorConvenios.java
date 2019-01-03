package cl.energiainteligente.convenios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cl.energiainteligente.dto.DTOBoletas;
import cl.energiainteligente.dto.DTOHumedad;
import cl.energiainteligente.dto.DTOInstituciones;
import cl.energiainteligente.dto.DTOMovimientos;
import cl.energiainteligente.dto.DTOconvenios;
import cl.energiainteligente.dto.DTOProdStock;
import cl.escritorio.persistencia.DBConectJDBC;

/**
* Clase Helper para mantener Tablas Convenios iLeniaSoft
* 
* @author http://rosseltech.cl
* @version 1.0
* @since AGO 2018
*/
public class MantenedorConvenios {
	
	/**
	 * Método Identidad iLeniaSoft
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
	 * Sobrecarga Método Identidad iLeniaSoft
	 * 
	 * @param String tabla
	 * @param String param
	 * @return int
	 */
	public int identidad (String tabla, String param){
		Connection dbsql = null;
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="select COUNT(*) from " + tabla + " WHERE " + param;
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
	 * Precio x código de Producto iLeniaSoft
	 * 
	 * @param CodProd
	 * @return int
	 */
	public int precioProducto (String CodProd){
		Connection dbsql = null;
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="select `eistkproductos`.`eistkprecio` "
					        + "from `orgdata`.`eistkproductos` " 
		                    + "where `eistkproductos`.`eistkcodigoP` ='" + CodProd + "'";
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
			System.out.println("ERROR: Fallo extracción precio lista");
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	public int accesoilenia (int numero) {
		Connection dbsql = null;
		@SuppressWarnings("unused")
		ResultSet Ret;
		int ret = 0;
		try{
			final String sql ="SELECT" + 
								"`accesoilenia`.`idaccesoilenia`," + 
									"`accesoilenia`.`claveusr`," + 
										"`accesoilenia`.`sistema`," + 
											"`accesoilenia`.`rut`," + 
												"`accesoilenia`.`razon`," + 
													"`accesoilenia`.`fono`," + 
														"`accesoilenia`.`fechavigencia`," + 
															"`accesoilenia`.`filler`" + 
																"FROM `orgdata`.`accesoilenia` " +
																	"WHERE `accesoilenia`.`claveusr`=" + numero;
			dbsql = new DBConectJDBC().getConection();
			PreparedStatement pStmt = dbsql.prepareStatement(sql);
			Ret = pStmt.executeQuery();
			/* recorrer el resulset */
			
			ret = 1;
		} catch (Exception e){
			System.out.println("ERROR: Fallo COUNT(*)");
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * Clase ActualizaCompraLaboratorio iLeniaSoft
	 * 
	 * @author RosselTech 2018
	 * 
	 * @param idmov
	 * @return int
	 * @throws SQLException
	 */
	public int ActualizaCompraLaboratorio (int idmov)  throws SQLException {
		Connection dbsql = null;	
		@SuppressWarnings("unused")
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* ------------------------------------ */
			String query ="UPDATE `orgdata`.`eistkmovfechacv` SET `eistktipodoc`='LABORATORIO' WHERE `ideistkMovfechaCV`=" + idmov;
			stmt.executeUpdate(query);
			stmt.close();
			return 1;
		} catch (Exception e) {
			System.out.println("ERROR: Fallo la Actualización al conectar con JDBC driver.");
			e.printStackTrace();
			return 0;
		} finally{
			if (dbsql != null) dbsql.close();
		}
		
		
	}
	
	
	/**
	 * GrabaConvenio
	 * 
	 * Clase de persistencia EnergiaInteligente iLeniaSoft
	 * 
	 * @author RosselTech 2018
	 * @param id
	 * @param rut
	 * @param razon
	 * @param email
	 * @param fono
	 * @param fecha
	 * @param msg
	 * @return
	 * @throws SQLException
	 */
	public int GrabaConvenio (int id, 
								String rut, 
									String razon, 
										String email, 
											String fono, 
												String fecha, 
													String msg)  throws SQLException {
		Connection dbsql = null;	
		@SuppressWarnings("unused")
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* ------------------------------------ */
			String query = "INSERT INTO `orgdata`.`eiconvenios` (ideiconvenios, eirut, eirazonsocial, eiemail, eifono, eifechavigencia, eimensaje) " + 
				  				  "VALUES (" + id + ", '" + 
								  				rut + "', '" + 
								  				 razon + "', ' " + 
								  				  email + "','" + 
								  				   fono + "', '" +
								  				    fecha + "', '" +
								  				     msg + "')";
			
			stmt.executeUpdate(query);
			stmt.close();
			
			return 1;	    
		
		} catch (Exception e) {
			System.out.println("ERROR: Fallo Inserción al conectar con JDBC driver.");
			e.printStackTrace();
			return 0;
		} finally{
			if (dbsql != null) dbsql.close();
		}

	}
	
	
	/**
	 * GrabaInstitucion iLeniaSoft
	 * 
	 * Clase de persistencia 
	 * 
	 * @since Rosseltech 10.2018
	 *  
	 * @param id
	 * @param razon
	 * @param codigo
	 * @param sector
	 * @param vigencia
	 * @param msgjson
	 * @return
	 * @throws SQLException
	 */
	public int GrabaInstitucion (int id, 
									String razon, 
										int codigo, 
											String sector, 
												String vigencia, 
													String msgjson)  throws SQLException {
		
		Connection dbsql = null;	
		@SuppressWarnings("unused")
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
		/* ------------------------------------ */
		dbsql = new DBConectJDBC().getConection();
		/* ------------------------------------ */
		Statement stmt = dbsql.createStatement();
		/* ------------------------------------ */
		String query = "INSERT INTO `orgdata`.`oopp` (idoopp, nombreoopp, codopp, sector, vigencia, filler) " + 
						  "VALUES (" + id + ", '" + 
					  				   razon + "', " + 
					  				   codigo + " ,'" + 
					  				   sector + "', '" +
					  				   vigencia + "', '" +
					  				   msgjson + "')";
		
		stmt.executeUpdate(query);
		stmt.close();
		
		return 1;	    
		
		} catch (Exception e) {
		System.out.println("ERROR: Fallo Insersión OOPP al conectar con JDBC driver.");
		e.printStackTrace();
		return 0;
		} finally{
		if (dbsql != null) dbsql.close();
		}
	
	}
	
	/**
	 * RegistraBoletaConvenio iLeniaSoft OCT 2018
	 * 
	 * @param id
	 * @param boleta
	 * @param codInstitucion
	 * @param neto
	 * @param iva
	 * @param totalBoleta
	 * @param filler
	 * @return int
	 * @throws SQLException
	 */
	public int RegistraBoletaConvenio (int id, 
										int boleta, 
											String codInstitucion, 
										int neto, 
										int iva,
										int totalBoleta,
											String filler)  throws SQLException {

				Connection dbsql = null;	
				@SuppressWarnings("unused")
				String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
				try {
				/* ------------------------------------ */
				dbsql = new DBConectJDBC().getConection();
				/* ------------------------------------ */
				Statement stmt = dbsql.createStatement();
				/* ------------------------------------ */
				String query = "INSERT INTO `orgdata`.`boletasconvenio`(`idboletasconvenio`,`boleta`,`codInstitucion`,`neto`,`iva`,`totalBoleta`,`filler`) " + 
								  "VALUES (" + id + "," + 
								  					boleta + " ,'" + 
								  						codInstitucion + "'," +
								  							neto + "," +
								  								iva + "," +
								  									totalBoleta + ", '" +
								  										filler + "')";
				
				stmt.executeUpdate(query);
				stmt.close();
				
				return 1;	    
				
				} catch (Exception e) {
				System.out.println("ERROR: Fallo Insersión boletasconvenio al conectar con JDBC driver.");
				e.printStackTrace();
				return 0;
				} finally{
				if (dbsql != null) dbsql.close();
				}
			
		}
	
	/**
	 * GrabaMovimiento y actualiza Stock de producto iLeniaSoft
	 * 
	 * Clase de persistencia EnergiaInteligente
	 * 
	 * @author RosselTech 2018
	 * @param id
	 * @param codigoP
	 * @param tipodoc
	 * @param rut
	 * @param numdoc
	 * @param fechamov
	 * @param unidades
	 * @param msg
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("resource")
	public int GrabaMovimiento (int id, 
									String codigoP, 
										String tipodoc, 
											String rut, 
												int numdoc,
													String fechamov,
														int unidades, 
															String msg,
																int humedad,
																	int distancia,
																	  String transporte,
																	    int valor,
																	    	double valoragr)  throws SQLException {
		/* --------------------------------------------------------------------------------- */
		Connection dbsql = null;
		ResultSet resultado = null;
		int stk = 0, stkh=0, stks=0;
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		
		/* cálculo de transformación de unidades kg/m3 */
		
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* ------------------------------------ */
			String query = "INSERT INTO `orgdata`.`eistkmovfechacv` (ideistkMovfechaCV, "
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
																	          + "valor, "
																	           + "valoragregado"
										    + ") VALUES (" + id + ",'" + 
															  codigoP + "', '" + 
															   tipodoc + "', ' " + 
															    rut + "'," + 
															     numdoc + ", '" +
															      fechamov + " " + Hora + "'," +
															       unidades + ", '" +
																    msg + "', " +
																     humedad + ", " +
																      distancia + ", '" +
																       transporte + "', " +
																         valor + ", " +
																          valoragr + ")";
			
			stmt.executeUpdate(query);
			stmt.close();
			/* -------------------------------------------------------------------------------------------- */
			String sql = "SELECT eistkP FROM `orgdata`.`eistkproductos` WHERE `eistkcodigoP`='" + codigoP + "'";
			/* -------------------------------------------------------------------------------------------- */
			PreparedStatement pStmt =  dbsql.prepareStatement(sql);  
			resultado = pStmt.executeQuery();
			/* ---------------------------- */
			if(resultado.next()){ 
				stk = resultado.getInt(1);
				stk = stk + unidades; 
			}
			/* ---------------------------- */
			resultado.close();
			pStmt.close();	
			/* ------------------------------------ */
			Statement stmtmov = dbsql.createStatement();
			/* ------------------------------------ */
			if (codigoP.equals("LSSTK")) {
				/* --------- */
				sql = "SELECT eistkP FROM `orgdata`.`eistkproductos` WHERE `eistkcodigoP`='LHCAM'";
				PreparedStatement pStmth =  dbsql.prepareStatement(sql);  
				resultado = pStmth.executeQuery();
				if(resultado.next()){ stkh = resultado.getInt(1);}
				stkh = (int) (stkh - unidades);
				resultado.close();
				pStmt.close();	
				/* ---------- */
				query = "UPDATE `orgdata`.`eistkproductos` SET `eistkP`=" + stkh + " WHERE `eistkcodigoP`='LHCAM'";
				/* ----------------------- */
				stmtmov.executeUpdate(query);
				/* ----------------------- */
				query = "UPDATE `orgdata`.`eistkproductos` SET `eistkP`=" + stk + " WHERE `eistkcodigoP`='" + codigoP + "'";
				/* ----------------------- */
				stmtmov.executeUpdate(query);
				/* ----------------------- */	
			}else if (codigoP.equals("LSCM3")) {
				/* -----  Plataforma secado ACOPIO  ---- */
				sql = "SELECT eistkP FROM `orgdata`.`eistkproductos` WHERE `eistkcodigoP`='LHCM3'";
				PreparedStatement pStmth =  dbsql.prepareStatement(sql);  
				resultado = pStmth.executeQuery();
				if(resultado.next()){ stkh = resultado.getInt(1);}
				stkh = (int) (stkh - unidades);
				resultado.close();
				pStmt.close();	
				/* ----------------------- */
				query = "UPDATE `orgdata`.`eistkproductos` SET `eistkP`=" + stkh + " WHERE `eistkcodigoP`='LHCM3'";
				/* ----------------------- */
				stmtmov.executeUpdate(query);
				/* ----------------------- */
				/* ----------------------- */
				query = "UPDATE `orgdata`.`eistkproductos` SET `eistkP`=" + stk + " WHERE `eistkcodigoP`='" + codigoP + "'";
				/* ----------------------- */
				stmtmov.executeUpdate(query);
				/* ----------------------- */
	
			} else {
				/* ----------------------- */
				sql = "SELECT eistkP FROM `orgdata`.`eistkproductos` WHERE `eistkcodigoP`='" + codigoP + "'";
				PreparedStatement pStmts =  dbsql.prepareStatement(sql);  
				resultado = pStmts.executeQuery();
				if(resultado.next()){ stks = resultado.getInt(1);}
				    /* ----------------------------- */
					if (tipodoc.equals("COMPRA")) {
						stks = (int) (stks + unidades);
					}else if (tipodoc.equals("GUIAINT")) {	
						stks = (int) (stks + unidades);
					}else {
						stks = (int) (stks - unidades);
					}
					/* ----------------------------- */	
				resultado.close();
				pStmt.close();	
				/* ---------- */
				query = "UPDATE `orgdata`.`eistkproductos` SET `eistkP`=" + stks + " WHERE `eistkcodigoP`='" + codigoP + "'";
				/* ----------------------- */
				stmtmov.executeUpdate(query);
				/* ----------------------- */
			}
			stmtmov.close();
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
	
	/**
	 * Listado de Stocks por Productos iLeniaSoft
	 * 
	 * @return listadoProdStock
	 * @throws SQLException
	 * @throws IOException
	 * @author http://rosseltech.cl
	 * @since AGO 2018 
	 */
	public ArrayList<DTOProdStock> ListaProdStock()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOProdStock stocks;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOProdStock> listadoProdStock = new ArrayList<DTOProdStock>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT ideistkProductos, "
											+ "eistkcodigoP, "
												+ "eistkdescripcion, "
													+ "eistkfiller, "
														+ "eistkprecio, "
															+ "eistkP "
																+ "FROM eistkproductos "
																	+ "ORDER BY ideistkProductos asc";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				while (resultado.next()) {
		        	/* --------------------- */
					stocks = new DTOProdStock();
		        	/* --------------------- */
					stocks.setIdstk(resultado.getInt(1));
					stocks.setStkcodigoP(resultado.getString(2));
					stocks.setStkdescripcion(resultado.getString(3));
					stocks.setStkfiller(resultado.getString(4));
					stocks.setStkprecio(resultado.getInt(5));
					stocks.setStkP(resultado.getInt(6));
		        	/* --------------------- */
					listadoProdStock.add(stocks);
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
			return listadoProdStock;	
		}
	
	/**
	 *  ListaCodProdStock  iLeniaSoft
	 *  
	 *  Listado de Codigo por Productos
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOProdStock> ListaCodProdStock()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOProdStock stocks;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOProdStock> listadoProdStock = new ArrayList<DTOProdStock>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT ideistkProductos, "
											+ "eistkcodigoP, "
												+ "eistkdescripcion, "
												   + "eistkprecio, "
												   		+ "eistkP "
																+ "FROM eistkproductos "
																	+ "ORDER BY ideistkProductos asc";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				while (resultado.next()) {
		        	/* --------------------- */
					stocks = new DTOProdStock();
		        	/* --------------------- */
					stocks.setIdstk(resultado.getInt(1));
					stocks.setStkcodigoP(resultado.getString(2));
					stocks.setStkdescripcion(resultado.getString(3));
					/* --------------------- */
					stocks.setStkP(resultado.getInt(4));
					stocks.setStkprecio(resultado.getInt(5));
		        	/* --------------------- */
					listadoProdStock.add(stocks);
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
			return listadoProdStock;	
		}
	
	
	/**
	 * Registro % de Humedad en Bines iLeniaSoft
	 * 
	 * @param id
	 * @param CodAndamio
	 * @param CodBin
	 * @param Humedad
	 * @param FechaRegistro
	 * @param Descripcion
	 * @param Salida
	 * @return int
	 * @throws SQLException
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 */
	 public int GrabaRegistroHumedad (int id, 
										String CodAndamio, 
											String CodBin, 
												String Humedad, 
													String FechaRegistro, 
														String Descripcion,
															String Salida)  throws SQLException {
		Connection dbsql = null;	
		@SuppressWarnings("unused")
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
		/* ------------------------------------ */
		dbsql = new DBConectJDBC().getConection();
		/* ------------------------------------ */
		Statement stmt = dbsql.createStatement();
		/* ------------------------------------ */
		String query = "INSERT INTO `orgdata`.`eistkRegAndBin` (ideistkRegAndBin, codandamio, codbin, factorhumedad, fecharegistro, descregistro, salida) " + 
						  "VALUES (" + id + ", '" + 
										  CodAndamio + "', '" + 
										  	CodBin + "', ' " + 
										  		Humedad + "','" + 
										  			FechaRegistro + "', '" +
										  				Descripcion + "', '" +
										  					Salida + "')";
		
		stmt.executeUpdate(query);
		stmt.close();
		
		return 1;	    
		
		} catch (Exception e) {
			System.out.println("ERROR: Fallo Inserción al conectar con JDBC driver.");
			e.printStackTrace();
			return 0;
		} finally{
			if (dbsql != null) dbsql.close();
		}
	
	}


	/**
	 * Lista Convenios EnergiaIntelegente iLeniaSoft
	 * 
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 * 
	 */
	public ArrayList<DTOconvenios> ListaConvenios()  throws SQLException, IOException {
	Connection dbcon = null;	
	ResultSet resultado = null;
	DTOconvenios convenio;
		/* ---------------------------------------------------------------- */
		ArrayList<DTOconvenios> listadoConvenios = new ArrayList<DTOconvenios>();	
		/* ---------------------------------------------------------------- */
		try {
			dbcon = new DBConectJDBC().getConection();
			final String sql = "SELECT ideiconvenios, "
										+ "eirut, "
											+ "eirazonsocial, "
												+ "eiemail, "
													+ "eifono, "
														+ "eifechavigencia, "
															+ "eimensaje "
																+ "FROM eiconvenios "
																	+ "ORDER BY ideiconvenios desc";
		    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
			resultado = pStmt.executeQuery();
			while (resultado.next()) {
	        	/* --------------------- */
				convenio = new DTOconvenios();
	        	/* --------------------- */
				convenio.setIdeiconvenios(resultado.getInt(1));
				convenio.setEirut(resultado.getString(2));
				convenio.setEirazonsocial(resultado.getString(3));
				convenio.setEiemail(resultado.getString(4));
				convenio.setEifono(resultado.getString(5));
				convenio.setEifechavigencia(resultado.getString(6));
				convenio.setEimensaje(resultado.getString(7));
	        	/* --------------------- */
				listadoConvenios.add(convenio);
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
		return listadoConvenios;	
	}
	
	
	/**
	 * ListaInstituciones iLeniaSoft
	 * 
	 * @since  OCT 2018 
	 * @author rosseltech.cl
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOInstituciones> ListaInstituciones()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOInstituciones institucion;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOInstituciones> listadoInstitucion = new ArrayList<DTOInstituciones>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT idoopp, "
											+ "nombreoopp, "
												+ "codopp, "
													+ "sector, "
														+ "vigencia, "
															+ "filler "
																	+ "FROM oopp "
																	+ "WHERE nombreoopp LIKE '%OSORNO%' "
																	+ "ORDER BY codopp desc";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				while (resultado.next()) {
		        	/* --------------------- */
					institucion = new DTOInstituciones();
		        	/* --------------------- */
					institucion.setIdidoopp(resultado.getInt(1));
					institucion.setNombreoopp(resultado.getString(2));
					institucion.setCodopp(resultado.getInt(3));
					institucion.setSector(resultado.getString(4));
					institucion.setVigencia(resultado.getString(5));
					institucion.setFiller(resultado.getString(6));
		        	/* --------------------- */
					listadoInstitucion.add(institucion);
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
			return listadoInstitucion;	
		}
	
	/**
	 * Totalizador Boletas
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public int TotalBoletas() throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		int Total = 0;
		
		try {	
			
			final String sql = "SELECT SUM(totalBoleta) AS TotalBoletas FROM boletasconvenio"; 
			dbcon = new DBConectJDBC().getConection();
			PreparedStatement pStmt = dbcon.prepareStatement(sql);
			resultado = pStmt.executeQuery();
			if(resultado.next()){
				Total = resultado.getInt(1);
			} else {
				Total = 0;	
			}
			resultado.close();
			pStmt.close();
			
		}catch (Exception e) {
			System.out.println("ERROR: Fallo al conectar con JDBC driver.");
			e.printStackTrace();
		}finally{
			if (dbcon != null) dbcon.close();
		}

		return Total;			
	}
	
	/**
	 * Sobrecarga 25.10.2018
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public int TotalBoletasxFecha(String filler) throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		int Total = 0;
		
		try {	
			
			final String sql = "SELECT SUM(totalBoleta) AS TotalBoletas FROM boletasconvenio " + filler; 
			dbcon = new DBConectJDBC().getConection();
			PreparedStatement pStmt = dbcon.prepareStatement(sql);
			resultado = pStmt.executeQuery();
			if(resultado.next()){
				Total = resultado.getInt(1);
			} else {
				Total = 0;	
			}
			resultado.close();
			pStmt.close();
			
		}catch (Exception e) {
			System.out.println("ERROR: Fallo al conectar con JDBC driver.");
			e.printStackTrace();
		}finally{
			if (dbcon != null) dbcon.close();
		}

		return Total;			
	}
	
	
	/**
	 * ListaBoletas 10.2018 iLeniaSoft
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOBoletas> ListaBoletas()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOBoletas boleta;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOBoletas> listadoBoleta = new ArrayList<DTOBoletas>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT idboletasconvenio, "
											+ "boleta, "
												+ "codInstitucion, "
													+ "neto, "
														+ "iva, "
														    + "totalBoleta, "
															   + "filler "
																	+ "FROM boletasconvenio "
																	+ "ORDER BY idboletasconvenio desc";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				long suma = 0;
				while (resultado.next()) {
		        	/* --------------------- */
					boleta = new DTOBoletas();
		        	/* --------------------- */
					boleta.setBid(resultado.getInt(1));
					boleta.setBboleta(resultado.getInt(2));
					boleta.setBcodInstitucion(resultado.getString(3));
					boleta.setBneto(resultado.getInt(4));
					boleta.setBiva(resultado.getInt(5));
					boleta.setBtotalBoleta(resultado.getInt(6));
					boleta.setBfiller(resultado.getString(7));
		        	/* --------------------- */
					listadoBoleta.add(boleta);
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
			return listadoBoleta;	
		}
	
	/**
	 * ListaBoletas Sobrecatga 25.2018 
	 * 
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOBoletas> ListaBoletasxfecha(String filler)  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOBoletas boleta;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOBoletas> listadoBoletaxfecha = new ArrayList<DTOBoletas>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT idboletasconvenio, "
											+ "boleta, "
												+ "codInstitucion, "
													+ "neto, "
														+ "iva, "
														    + "totalBoleta, "
															   + "filler "
																	+ "FROM boletasconvenio "
																	+ filler 
																	+ " ORDER BY idboletasconvenio desc";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				long suma = 0;
				while (resultado.next()) {
		        	/* --------------------- */
					boleta = new DTOBoletas();
		        	/* --------------------- */
					boleta.setBid(resultado.getInt(1));
					boleta.setBboleta(resultado.getInt(2));
					boleta.setBcodInstitucion(resultado.getString(3));
					boleta.setBneto(resultado.getInt(4));
					boleta.setBiva(resultado.getInt(5));
					boleta.setBtotalBoleta(resultado.getInt(6));
					boleta.setBfiller(resultado.getString(7));
		        	/* --------------------- */
					listadoBoletaxfecha.add(boleta);
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
			return listadoBoletaxfecha;	
		}
	
	/**
	 * ListaFillerJSON iLeniaSoft
	 * 
	 * @param numdoc
	 * @return FormatoFillerJSON
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<DTOMovimientos> ListaFillerJSON(int numdoc) throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOMovimientos fillerjason;	
		/* ------------------------------------------------------------------------ */
		ArrayList<DTOMovimientos> listaFillerJASON = new ArrayList<DTOMovimientos>();	
		/* ------------------------------------------------------------------------- */
		try {
			dbcon = new DBConectJDBC().getConection();
			final String sql = "SELECT eistkfechamovimiento,eistkfiller "
					           + "FROM eistkmovfechacv "
					           + "WHERE ideistkMovfechaCV=" +numdoc;
			/* -------------------------------------------------- */
		    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
			resultado = pStmt.executeQuery();
			while (resultado.next()) {
	        	/* ----------------------------- */
				fillerjason = new DTOMovimientos();
	        	/* ----------------------------- */
				fillerjason.setEifechamovimiento(resultado.getString(1));
				fillerjason.setEifiller(resultado.getString(2));
				/* ----------------------------- */	
				listaFillerJASON.add(fillerjason);
			}
		}catch (Exception e) {
			System.out.println("ERROR: Fallo al conectar ListaFillerJSON con JDBC driver.");
			e.printStackTrace();
		}finally{
			if (dbcon != null) dbcon.close();
		}
		return listaFillerJASON;
	}
	/**
	 * Lista Movimientos EnergiaIntelegente iLeniaSoft
	 * 
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 * 
	 */
	public ArrayList<DTOMovimientos> ListaMovimientos()  throws SQLException, IOException {
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
															    					+ "FROM eistkmovfechacv"
															    						+ " ORDER BY eistktipodoc desc, eistkfechamovimiento desc";  /* eistkcodigoP */
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
	 * Lista Movimientos EnergiaIntelegente iLeniaSoft
	 * 
	 * Sobrecarga del método por Tipo Documento 
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 * 
	 */
	public ArrayList<DTOMovimientos> ListaMovimientos(String tipodoc)  throws SQLException, IOException {
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
																			   	  		+	" WHERE eistktipodoc ='" + tipodoc + "'"  
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
	 * Lista Movimientos EnergiaIntelegente iLeniaSoft
	 * 
	 * Sobrecarga del método por Tipo Documento COMPRA y PRODUCTO 
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 * 
	 */
	public ArrayList<DTOMovimientos> ListaMovimientos(String producto, String tipodoc)  throws SQLException, IOException {
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
											   	  		+ " WHERE eistkcodigoP ='" + producto + "' "
											   	  		    + "AND eistktipodoc ='" + tipodoc + "' "
											   	  			   + " ORDER BY eistkfechamovimiento desc LIMIT 10";
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
	 * Lista Humedad EnergiaIntelegente iLeniaSoft
	 * 
	 * @return listadoHumedad
	 * @throws SQLException
	 * @throws IOException
	 * 
	 * @author http://rosseltech.cl
	 * @since AGO 2018
	 */
	public ArrayList<DTOHumedad> ListaHumedad()  throws SQLException, IOException {
		Connection dbcon = null;	
		ResultSet resultado = null;
		DTOHumedad humedad;
			/* ---------------------------------------------------------------- */
			ArrayList<DTOHumedad> listadoHumedad = new ArrayList<DTOHumedad>();	
			/* ---------------------------------------------------------------- */
			try {
				dbcon = new DBConectJDBC().getConection();
				final String sql = "SELECT ideistkRegAndBin, "
											+ "codandamio, "
												+ "codbin, "
													+ "factorhumedad, "
														+ "fecharegistro, "
															+ "descregistro, "
																+ "salida "
																	+ "FROM eistkRegAndBin "
																		+ "ORDER BY codandamio, codbin, fecharegistro";
			    PreparedStatement pStmt =  dbcon.prepareStatement(sql);  
				resultado = pStmt.executeQuery();
				while (resultado.next()) {
		        	/* --------------------- */
					humedad = new DTOHumedad();
		        	/* --------------------- */
					humedad.setId(resultado.getInt(1));
					humedad.setCodAndamio(resultado.getString(2));
					humedad.setCodBin(resultado.getString(3));
					humedad.setHumedad(resultado.getString(4));
					humedad.setFechaRegistro(resultado.getString(5));
					humedad.setDescripcion(resultado.getString(6));
					humedad.setSalida(resultado.getString(7));

		        	/* --------------------- */
					listadoHumedad.add(humedad);
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
		return listadoHumedad;	
	}
	
}
