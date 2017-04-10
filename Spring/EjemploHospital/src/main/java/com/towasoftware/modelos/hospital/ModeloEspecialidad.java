package com.towasoftware.modelos.hospital;



public class ModeloEspecialidad {

	int id;
	String Nombre;
	int idDepartamento;
	
	public ModeloEspecialidad(int id, String nombre, int idDepartamento) {
		super();
		this.id = id;
		Nombre = nombre;
		this.idDepartamento = idDepartamento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
	@Override
	public String toString() {
		return "ModeloEspecialidad [id=" + id + ", Nombre=" + Nombre + ", idDepartamento=" + idDepartamento + "]";
	}
	
	
}
