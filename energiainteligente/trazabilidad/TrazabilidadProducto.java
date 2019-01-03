package cl.energiainteligente.trazabilidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import cl.escritorio.persistencia.DBConectJDBC;

public class TrazabilidadProducto {
	
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
	 * GrabaProducto eistkproductos
	 * 
	 * @since 2018
	 * @param id
	 * @param codigo
	 * @param descripcion
	 * @param filler
	 * @param precio
	 * @param stk
	 * @return int
	 * @throws SQLException
	 */
	public int GrabaProducto(int id, 
								String codigo, 
									String descripcion, 
										String filler,
											int precio, 
												int stk )  throws SQLException {
		Connection dbsql = null;	
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* -------------------------------------------------------------------- */
			String query = "INSERT INTO `orgdata`.`eistkproductos`" + 
													"(`ideistkProductos`," + 
														"`eistkcodigoP`," + 
															"`eistkdescripcion`," + 
																"`eistkfiller`," + 
																	"`eistkprecio`," + 
																		"`eistkP`) " + 
	  				  					" VALUES (" + id + ", '" + 
						  				  				codigo + "', '" + 
						  				  					descripcion + "', ' " + 
						  				  						filler + "','" + 
						  				  							precio + "', '" +
						  				  								stk + "')";
			/* ----------------------------------------------------------------------- */
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
	 * ActualizaProducto  eistkproductos
	 * 
	 * @author rosseltech.cl
	 * @since 2018
	 * @param codigo
	 * @param precio
	 * @return int
	 * @throws SQLException
	 */
	public int ActualizaProducto (String codigo, int precio)  throws SQLException {
		Connection dbsql = null;	
		@SuppressWarnings("unused")
		String Hora  = new SimpleDateFormat("hh:mm:ss").format(new Date());
		try {
			/* ------------------------------------ */
			dbsql = new DBConectJDBC().getConection();
			/* ------------------------------------ */
			Statement stmt = dbsql.createStatement();
			/* ------------------------------------ */
			String query ="UPDATE `orgdata`.`eistkproductos` SET `eistkprecio`=" + precio + " WHERE `eistkcodigoP`=" + codigo;
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

}
