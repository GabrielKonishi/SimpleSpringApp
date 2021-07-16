package com.registry.vc.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.registry.vc.model.Patient;

public class PatientRequestDto {

	@NotBlank
	private String name;

	@Email
	@NotBlank
	private String email;

	@CPF
	@NotBlank
	private String cpf;

	@NotNull
	private LocalDate dataNascimento;

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

	public PatientRequestDto(String name, String email, String cpf, LocalDate dataNascimento) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public PatientRequestDto() {
		super();
	}

	public Patient toPatientRequest() {
		return new Patient(name, email, cpf, dataNascimento);
	}

}
