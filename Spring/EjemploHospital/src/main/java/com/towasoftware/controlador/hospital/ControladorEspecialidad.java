package com.towasoftware.controlador.hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.towasoftware.conexionBd.Conex;
import com.towasoftware.conexionBd.Crud;
import com.towasoftware.modelos.hospital.ModeloEspecialidad;

@Controller
@RequestMapping(value = "/especialidades")
public class ControladorEspecialidad {

	@RequestMapping(method = RequestMethod.POST)
	public String altaEspecialidad(Model modelo, @RequestParam String nombre, @RequestParam int idDepartamento){
		String insert="INSERT INTO especialidad(Nombre, IdDepartamento)"
				+ " VALUES('"+nombre+"' , "+idDepartamento+" )";
		
		Crud.crud(insert);
		
		return"home";
	}		
	
	@RequestMapping(value = "/{id}/{nombre}/{idDepartamento}" , method = RequestMethod.PUT)
	public String actualizaEspecialidad(Model modelo, @PathVariable int id, @PathVariable String nombre, @PathVariable int idDepartamento){
		String update ="UPDATE especialidad SET Nombre ='"+nombre+"', IdDepartamento= "+idDepartamento+" WHERE IdDepartamento = "+id+" ";
		Crud.crud(update);
		return "home";
	}
	
	@RequestMapping ( value = "/{id}", method = RequestMethod.DELETE)
	public String eliminaEspecialidad(Model model , @PathVariable int id){
		
		String delete="DELETE FROM especialidad WHERE IdEspecialidad = "+id+" ";
		
		Crud.crud(delete);
		
		return"home";
	}	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ModeloEspecialidad> obtenerEspecialidades(){
		
		String query="SELECT * FROM especialidad";
		List<ModeloEspecialidad> lista = obtenerlista(query);
		return lista;
	}

	private List<ModeloEspecialidad> obtenerlista(String query){
		List<ModeloEspecialidad> lista = new ArrayList<ModeloEspecialidad>();
		Conex conex = new Conex();
		ResultSet rs;		
		try{
			conex.consulta(query);
			rs=conex.getRS();
			while(rs.next()){
				ModeloEspecialidad modelo = new ModeloEspecialidad(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3))) ;
				lista.add(modelo);
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			conex.close();
		}
		return lista;
	}
}