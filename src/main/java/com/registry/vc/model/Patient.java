package com.registry.vc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;


@Entity(name = "patient") //anotaçao jpa, é mapeada para uma tabela no banco de dados
public class Patient extends AbstractEntity{
	
	@NotBlank(message = "o email deve ser preenchido")
	private String name;
	
	@NotBlank(message = "o email deve ser preenchido")
	private String email;
	
	@NotBlank(message = "o cpf deve ser preenchido")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "o cpf deve ser preenchido")
	private String dataNascimento;
	
	@OneToMany
	private List<Vaccine> vaccine;
	
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
	
}
