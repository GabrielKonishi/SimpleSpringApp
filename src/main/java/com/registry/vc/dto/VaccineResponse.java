package com.registry.vc.dto;



import com.registry.vc.model.Patient;

public class VaccineResponse {
	
	private String vaccineName;
	
	private String patientEmail;
	
	private String dataAplicada;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	
	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getDataAplicada() {
		return dataAplicada;
	}

	public void setDataAplicada(String dataAplicada) {
		this.dataAplicada = dataAplicada;
	}
	
	
}
