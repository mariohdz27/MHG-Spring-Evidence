package com.towasoftware.modelos.hospital;

public class ModeloConsultorio {

	private Integer idConsultorio;
	private Integer idDepartamento;
	private String piso;
	
	public ModeloConsultorio(){
		
	}
	
	
	public ModeloConsultorio(Integer idConsultorio, Integer idDepartamento, String piso) {
		super();
		this.idConsultorio = idConsultorio;
		this.idDepartamento = idDepartamento;
		this.piso = piso;
	}


	public Integer getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(Integer idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	
	@Override
	public String toString() {
		return "ModeloConsultorio [idConsultorio=" + idConsultorio + ", idDepartamento=" + idDepartamento + ", piso="
				+ piso + "]";
	}
	
	
}
