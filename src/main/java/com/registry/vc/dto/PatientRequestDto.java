package com.registry.vc.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.registry.vc.model.Patient;

public class PatientRequestDto {

	private String name;
	
	private String email;
	
	private String cpf;
	
	private String dataNascimento;

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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PatientRequestDto(String name, String email, String cpf, String dataNascimento) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public PatientRequestDto() {
		super();
	}
	
	public Patient toPatientRequest(){
	    return new Patient(name, email, cpf, dataNascimento);
	}
	
}
