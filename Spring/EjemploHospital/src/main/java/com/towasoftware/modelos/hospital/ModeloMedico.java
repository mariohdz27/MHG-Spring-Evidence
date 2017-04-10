package com.towasoftware.modelos.hospital;

public class ModeloMedico {
	
	String nombre ;
	String apellido;
	int idEspecialidad;
	int telefono;
	String correo;
	String direccion;
	String cedula;
	int idMedico;
	
	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public ModeloMedico(String nombre, String apellido, int idEspecialidad, int telefono, String correo, String direccion,
			String cedula, int idMedico) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.idEspecialidad = idEspecialidad;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.cedula = cedula;
		this.idMedico = idMedico;
	}

	public ModeloMedico() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getIdEspecialidad() {
		return this.idEspecialidad;
	}
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public int getTelefono() {
		return this.telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return this.correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCedula() {
		return this.cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", IdEspecialidad=" + idEspecialidad
				+ ", telefono=" + telefono + ", correo=" + correo + ", Direccion=" + direccion + ", cedula=" + cedula
				+ "]";
	}
}
