package com.towasoftware.conexionBd;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

	public static void main(String[] args) {
		consulta(" Select * From paciente", 12);
		/*insert("INSERT INTO Departamento (Nombre)"
				+ "VALUES('Ginecologia')");*/
		//crud("Delete From Departamento where IdDepartamento = 1");
		//crud("Update Departamento set Nombre = 'Cardiologia' Where IdDepartamento= 2");
		
		
	}
	
	public static void consulta(String query, int numColumnas){
		Conex conex = new Conex();
		ResultSet rs;		
		try{
			conex.consulta(query);
			rs=conex.getRS();
			while(rs.next()){
				for(int i = 1 ; i < numColumnas; i++){
					System.out.println(conex.getRS().getString(i));
				}
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			conex.close();
		}
		
	}
	
	public static boolean crud(String query){
		Conex conex = new Conex();
		boolean bandera=false;
		int regresa;
		try{
		regresa=conex.crud(query);
		if(regresa==1){
			bandera=true;
		}else{
			bandera=false;
		}
		
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			bandera = false;
		}finally{
			conex.close();
		}
		return bandera;
	}		
}