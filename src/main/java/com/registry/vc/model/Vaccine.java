package com.registry.vc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "vaccine")
public class Vaccine{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vaccine_name",nullable = false)
	private String vaccineName;
	
	@NotNull(message = "Favor identificar o id do usuario")
	@ManyToOne
	private Patient patient;
	
	
	@Column(name="data_aplicada", nullable = false)
	private String dataAplicada;
	
	
	
	public Vaccine() {
		super();
	}

	
	
	public Vaccine(String vaccineName, @NotNull(message = "Favor identificar o id do usuario") Patient patient,
			String dataAplicada) {
		super();
		this.vaccineName = vaccineName;
		this.patient = patient;
		this.dataAplicada = dataAplicada;
	}



	public Vaccine(String vaccineName, String patientEmail, String dataAplicada) {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		Vaccine other = (Vaccine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
