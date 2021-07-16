package com.registry.vc.dto;

import java.time.LocalDate;

public class VaccineResponseDto {
	
	private String vaccineName;
	
	private String patientEmail;
	
	private LocalDate dataAplicada;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	
	public VaccineResponseDto() {
		super();
	}

	public VaccineResponseDto(String vaccineName, String patientEmail, LocalDate dataAplicada) {
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

	public LocalDate getDataAplicada() {
		return dataAplicada;
	}

	public void setDataAplicada(LocalDate dataAplicada) {
		this.dataAplicada = dataAplicada;
	}
	
}
