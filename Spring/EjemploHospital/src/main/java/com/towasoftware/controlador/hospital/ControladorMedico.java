package com.towasoftware.controlador.hospital;



import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.towasoftware.conexionBd.Conex;
import com.towasoftware.conexionBd.Crud;
import com.towasoftware.modelos.hospital.ModeloMedico;


@Controller
@RequestMapping(value = "/medico" )
public class ControladorMedico {
	
	@RequestMapping( method = RequestMethod.POST)
	public  String altaMedico(Model modelo,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("idEspecialidad") int idEspecialidad,
			@RequestParam("telefono") int telefono,
			@RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam("cedula") String cedula
			){

		
		String insert="INSERT INTO medico (Nombre , Apellido, IdEspecialidad,Telefono, Correo, Direccion, Cedula)"
				+ " VALUES('"+nombre +"',"
						+ "'"+apellido+"',"
						+ ""+idEspecialidad+","
						+ ""+telefono+","
						+ "'"+correo+"',"
						+ "'"+direccion+"',"
						+ "'"+cedula+"'"
						+ ")";
		
		
				Crud.crud(insert);
		return "home";
	}
	
	@RequestMapping(value="/{id}/{nombre}/{apellido}/{idEspecialidad}/{telefono}/{correo}/{direccion}/{cedula}" , method = RequestMethod.PUT)
	public String updateMedico (Model modelo,
			@PathVariable Integer id,
			@PathVariable String nombre,
			@PathVariable String apellido,
			@PathVariable String idEspecialidad,
			@PathVariable Integer telefono,
			@PathVariable String correo,
			@PathVariable String direccion,
			@PathVariable String cedula
			){
		String update="UPDATE medico SET Nombre='"+nombre+"', "
										+ " Apellido='"+apellido+"', "
										+ " IdEspecialidad="+idEspecialidad+", "
										+ " Telefono="+telefono+", "
										+ " Correo='"+correo+"', "
										+ " Direccion='"+direccion+"', "
										+ " Cedula='"+direccion+"'"
										+ " WHERE IdMedico="+id+"";
		Crud.crud(update);
		
		return"home";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE )
	public String deleteMedico(Model modelo, @PathVariable Integer id){
		
		String delete="DELETE FROM medico WHERE idMedico="+id+"";
		Crud.crud(delete);
		
		return "home";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String consultaMedicoId(Model modelo, @PathVariable Integer id){
		String consulta ="SELECT * FROM medico WHERE idMedico= "+id+" ";
		consulta(consulta, 8);
		return"home";
	}
	
	public  void consulta(String query, int numColumnas){
		Conex conex = new Conex();
		ModeloMedico modelo = new ModeloMedico();
		ResultSet rs;		
		try{
			conex.consulta(query);
			rs=conex.getRS();
			while(rs.next()){
				modelo.setIdMedico(Integer.parseInt(conex.getRS().getString(1)));
				modelo.setNombre(conex.getRS().getString(2));
				modelo.setApellido(conex.getRS().getString(3));
				modelo.setIdEspecialidad(Integer.parseInt(conex.getRS().getString(4)));
				modelo.setTelefono(Integer.parseInt(conex.getRS().getString(5)));
				modelo.setCorreo(conex.getRS().getString(6));
				modelo.setDireccion(conex.getRS().getString(7));
				modelo.setCedula(conex.getRS().getString(8));
			}
			System.out.println("Id: " + modelo.getIdMedico()
			+ " Nombre: " + modelo.getNombre()
			+ " Apellido: " + modelo.getApellido()
			+ " IdEspecialidad: " + modelo.getIdEspecialidad()
			+ " Telefono: " + modelo.getTelefono()
			+ " Correo: " + modelo.getCorreo()
			+ " Dirección: " + modelo.getDireccion()
			+" Cedula: " + modelo.getCedula() 				
			);
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			conex.close();
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String consultaTodosMedicos (Model modelo){
		String query ="SELECT * FROM medico";
		Crud.consulta(query, 8);
		return "home";
	}	
}