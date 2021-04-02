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
public class Patient{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	


	public Patient() {
		super();
	}


	public Patient(@NotBlank(message = "o email deve ser preenchido") String name,
			@NotBlank(message = "o email deve ser preenchido") String email,
			@NotBlank(message = "o cpf deve ser preenchido") String cpf,
			@NotBlank(message = "o cpf deve ser preenchido") String dataNascimento) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
}
