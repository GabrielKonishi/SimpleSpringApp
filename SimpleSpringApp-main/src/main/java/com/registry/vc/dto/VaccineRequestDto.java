package com.registry.vc.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;

public class VaccineRequestDto {

	@NotBlank
	private String vaccineName;

	@NotNull
	private Patient patient;

	@NotNull
	private LocalDate dataAplicada;

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

	public LocalDate getDataAplicada() {
		return dataAplicada;
	}

	public void setDataAplicada(LocalDate dataAplicada) {
		this.dataAplicada = dataAplicada;
	}

	public VaccineRequestDto(String vaccineName, Patient patient, LocalDate dataAplicada) {
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
