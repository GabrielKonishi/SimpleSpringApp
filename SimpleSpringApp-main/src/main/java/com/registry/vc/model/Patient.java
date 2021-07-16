package com.registry.vc.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.transaction.annotation.Transactional;

import com.registry.vc.dto.PatientResponseDto;

@Transactional
@Entity(name = "patient") // anotaçao jpa, é mapeada para uma tabela no banco de dados
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(unique = true, length = 75, nullable = false)
	private String email;

	@Column(unique = true, length = 11, nullable = false)
	private String cpf;

	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Vaccine> vaccine;

	public Patient() {
		super();
	}

	public Patient(@NotBlank(message = "o email deve ser preenchido") String name,
			@NotBlank(message = "o email deve ser preenchido") String email,
			@NotBlank(message = "o cpf deve ser preenchido") String cpf,
			@NotBlank(message = "o cpf deve ser preenchido") LocalDate dataNascimento) {
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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
