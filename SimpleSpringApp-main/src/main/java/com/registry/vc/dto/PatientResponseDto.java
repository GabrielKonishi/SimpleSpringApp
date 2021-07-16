package com.registry.vc.dto;

import java.time.LocalDate;

import com.registry.vc.model.Patient;

public class PatientResponseDto {
	private String name;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;

	public PatientResponseDto() {
		super();
	}

	public PatientResponseDto(String name, String email, String cpf, LocalDate dataNascimento) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Patient toPatient() {
		return new Patient(name, email, cpf, dataNascimento);
	}

	public Patient toPatientResponse() {
		return new Patient(name, email, cpf, dataNascimento);
	}
	
	public PatientResponseDto toPatientDto(Patient patient) {
		var patientDto = new PatientResponseDto();
		patientDto.setName(patient.getName());
		patientDto.setEmail(patient.getEmail());
		patientDto.setCpf(patient.getCpf());
		patientDto.setDataNascimento(patient.getDataNascimento());
		return patientDto;

	}

}
