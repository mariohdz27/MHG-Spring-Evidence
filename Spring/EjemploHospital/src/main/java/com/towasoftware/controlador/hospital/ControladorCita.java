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

@Controller
@RequestMapping(value = "/citas", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
public class ControladorCita {
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ModeloCita altaCita(@RequestBody ModeloCita cita){
		
		String insert="INSERT INTO cita (Fecha, IdPaciente, IdMedico, IdConsultorio) "
				+ "VALUES ('"+cita.getFecha()+"', "+cita.getIdPaciente()+", "+cita.getIdMedico()+", "+cita.getIdConsultorio()+");";
		Crud.crud(insert);	
		return cita;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ModeloCita> obtenerCitas() {

		String consulta ="SELECT * FROM cita ";
		
		List<ModeloCita> lstcita = this.generateList(5,consulta);

		return lstcita;

	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public @ResponseBody List<ModeloCita> obtenerCitasPorId(@PathVariable Integer id ) {

		String consulta ="SELECT * FROM cita WHERE IdCita = " + id;
		
		List<ModeloCita> lstcita = this.generateList(5,consulta);

		return lstcita;

	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	public @ResponseBody ModeloCita actualizaCitas(@PathVariable Integer id, @RequestBody ModeloCita cita ) {

		String query ="UPDATE cita set Fecha = '"+cita.getFecha()+"', "
				+ "Idpaciente = "+cita.getIdPaciente()+", "
				+ "IdMedico = "+cita.getIdMedico()+", "
				+ "IdConsultorio = "+cita.getIdConsultorio()+""
				+ "WHERE IdCita = " + id;
		Crud.crud(query);
		
		return cita;

	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	public @ResponseBody boolean eliminaCitas(@PathVariable Integer id ) {

		boolean bandera= false;
		
		String query ="DELETE FROM cita Where idCita = "+id;
		
		bandera=Crud.crud(query);
		
		return bandera;

	}
	
	private List<ModeloCita> generateList(int columnas, String consulta) {
	
		List<ModeloCita> list = new ArrayList<ModeloCita>();
	
		Conex conex = new Conex();
		ResultSet rs;		
		try{
			conex.consulta(consulta);
			rs=conex.getRS();
			while(rs.next()){
					ModeloCita u = new ModeloCita(Integer.parseInt(rs.getString(1)), "fecha " + rs.getString(2),Integer.parseInt( rs.getString(3)), 
							Integer.parseInt(rs.getString(4)),Integer.parseInt( rs.getString(5)));
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
