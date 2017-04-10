package com.towasoftware.controlador.hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.towasoftware.conexionBd.Conex;
import com.towasoftware.conexionBd.Crud;
import com.towasoftware.modelos.hospital.ModeloCita;
import com.towasoftware.modelos.hospital.ModeloConsultorio;

@Controller
@RequestMapping( value ="/consultorio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ControladorConsultorio {

	@RequestMapping(method = RequestMethod.POST )
	public @ResponseBody ModeloConsultorio altaConsultorio(@RequestBody ModeloConsultorio consultorio){
		
		String insert= "INSERT INTO consultorio (IdDepartamento, Piso) "
					+ "VALUES("+consultorio.getIdDepartamento()+" , '"+consultorio.getPiso()+"')";
		Crud.crud(insert);
		
		return consultorio;
	}
	
	@RequestMapping( method = RequestMethod.GET )
	public @ResponseBody List<ModeloConsultorio> obtenerConsultorio(){
		
		String consulta ="SELECT * FROM consultorio";
		
		List<ModeloConsultorio> listaConsultorio = this.generateList(3,consulta);

		return listaConsultorio;
		
	}
	
	@RequestMapping( value ="/{id}",method = RequestMethod.GET )
	public @ResponseBody List<ModeloConsultorio> obtenerConsultorioId(@PathVariable int id){
		
		String consulta ="SELECT * FROM consultorio WHERE IdConsultorio = "+id;
		
		List<ModeloConsultorio> listaConsultorio = this.generateList(3,consulta);

		return listaConsultorio;
		
	}
	
	
	@RequestMapping(value ="/{id}" , method= RequestMethod.PUT)
	public @ResponseBody ModeloConsultorio actualizarConsultorio(@PathVariable Integer id ,@RequestBody ModeloConsultorio consultorio){
		
		String update ="UPDATE consultorio SET "
						+ "IdDepartamento= "+consultorio.getIdDepartamento()+","
						+ "Piso= '"+consultorio.getPiso()+"' "
						+ "WHERE IdConsultorio =" +id;
		Crud.crud(update);
		
		return consultorio;
	}
	
	@RequestMapping(value ="/{id}" , method = RequestMethod.DELETE)
	public @ResponseBody boolean eliminaConsultorio(@PathVariable int id){
		boolean bandera= false;
		String delete ="DELETE FROM consultorio WHERE IdConsultorio=" + id;
		bandera=Crud.crud(delete);
		return bandera;
	}
	
	
	
	
	
	private List<ModeloConsultorio> generateList(int columnas, String consulta) {
		
		List<ModeloConsultorio> list = new ArrayList<ModeloConsultorio>();
	
		Conex conex = new Conex();
		ResultSet rs;		
		try{
			conex.consulta(consulta);
			rs=conex.getRS();
			while(rs.next()){
					ModeloConsultorio u = new ModeloConsultorio(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)),rs.getString(3));
					list.add(u);		
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			conex.close();
		}
		return list;
	}
		
}