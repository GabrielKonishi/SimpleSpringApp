package com.registry.vc.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;

public class VaccineRequestDto {
	
	
	private String vaccineName;
	
	private Patient patient;
	
	private String dataAplicada;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDataAplicada() {
		return dataAplicada;
	}

	public void setDataAplicada(String dataAplicada) {
		this.dataAplicada = dataAplicada;
	}

	public VaccineRequestDto(String vaccineName, Patient patient, String dataAplicada) {
		super();
		this.vaccineName = vaccineName;
		this.patient = patient;
		this.dataAplicada = dataAplicada;
	}

	public VaccineRequestDto() {
		super();
	}
	
	public Vaccine toVaccineRequest() {
		return new Vaccine(vaccineName, patient, dataAplicada);
	}
	
	
}
