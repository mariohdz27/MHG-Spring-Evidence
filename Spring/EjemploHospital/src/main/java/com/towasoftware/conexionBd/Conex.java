package com.towasoftware.conexionBd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Conex {		

	private Connection cnn;
	private Statement st;
	private ResultSet rs;
	private CallableStatement cstmt;
	
	public Conex() {

		cnn = null;
		st = null;
		rs = null;
		cstmt = null;
	}
	
	// Datos de conexión
		private int conec() throws SQLException {
					
			MysqlDataSource sqlserverdatasource = new MysqlDataSource();
			sqlserverdatasource.setUser("root");
			sqlserverdatasource.setPassword("root");
			sqlserverdatasource.setServerName("127.0.0.1");
			sqlserverdatasource.setPortNumber(3306);
			sqlserverdatasource.setDatabaseName("Hospital");
			cnn = sqlserverdatasource.getConnection();	
			
		return-3;
		}

		public ResultSet getRS() {
			return rs;
		}
		
		
		/**
		 * Metodo para hacer consultas
		 * @param s
x		 * @return
		 * @throws SQLException
		 */
		public int consulta(String s) throws SQLException {
			int i = conec();
					// Si la conexion fue exitosa
			if (i == -3) 
				try {
					st = cnn.createStatement();
					rs = st.executeQuery(s);
					i = 1;
				} catch (SQLException sqlexception) {
					System.out.println((new StringBuilder()).append("(open)-->")
							.append(s).append("\n").append(sqlexception)
							.append("\n").toString());
					i = -1;
					close();
				}
			else
				System.out.println("Error de conexion con el servidor para realizar una consulta");
			return i;
		}
		
		
		public int crud(String s) throws SQLException{
			int i = conec();
			// Si la conexion fue exitosa
			if (i == -3) 
				try {
					st = cnn.createStatement();
					st.executeUpdate(s);
					i = 1;
				}catch (SQLException sqlexception) {
					System.out.println((new StringBuilder()).append("(open)-->").append(s).append("\n").append(sqlexception).append("\n").toString());
					i = -1;
					close();
				}
			else
				System.out.println("Error de conexion con el servidor para realizar una consulta");
			return i;
		}


		public void close() {
			try {
				if (st != null)
					st.close();
				if (cnn != null)
					cnn.close();
				if (cstmt != null)
					cstmt.close();
				rs = null;
				st = null;
				cstmt = null;
				cnn = null;
			} catch (SQLException sqlexception) {
				System.out.println((new StringBuilder()).append("(close)-->")
						.append(sqlexception).append("\n").toString());
			}
		}		
}