package com.towasoftware.modelos.hospital;

public class ModeloCita {
	
	Integer idCita;
	String fecha;
	Integer idPaciente;
	Integer idMedico;
	Integer idConsultorio;
	
	public ModeloCita(){
		
	}
	
	
	
	public ModeloCita(Integer idCita, String fecha, Integer idPaciente, Integer idMedico, Integer idConsultorio) {
		super();
		this.idCita = idCita;
		this.fecha = fecha;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.idConsultorio = idConsultorio;
	}



	@Override
	public String toString() {
		return "ModeloCita [idCita=" + idCita + ", fecha=" + fecha + ", idPaciente=" + idPaciente + ", idMedico="
				+ idMedico + ", idConsultorio=" + idConsultorio + "]";
	}



	public Integer getIdCita() {
		return idCita;
	}



	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}



	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(Integer idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
	
	
	

}
