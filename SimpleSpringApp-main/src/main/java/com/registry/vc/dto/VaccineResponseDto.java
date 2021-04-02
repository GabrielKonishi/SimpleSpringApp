package com.registry.vc.dto;



import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;

public class VaccineResponseDto {
	
	private String vaccineName;
	
	private String patientEmail;
	
	private String dataAplicada;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	
	public VaccineResponseDto() {
		super();
	}

	public VaccineResponseDto(String vaccineName, String patientEmail, String dataAplicada) {
		super();
		this.vaccineName = vaccineName;
		this.patientEmail = patientEmail;
		this.dataAplicada = dataAplicada;
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
