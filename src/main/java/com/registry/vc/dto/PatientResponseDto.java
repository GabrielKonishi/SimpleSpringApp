package com.registry.vc.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;

public class PatientResponseDto {
	private String name;
	private String email;
	private String cpf;
	private String dataNascimento;
	
	public PatientResponseDto() {
		super();
	}
	public PatientResponseDto(String name, String email, String cpf, String dataNascimento) {
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public Patient toPatient(){
	    return new Patient(name, email, cpf, dataNascimento);
	}
	
}
