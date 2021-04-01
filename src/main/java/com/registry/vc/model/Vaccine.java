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
public class Vaccine extends AbstractEntity{
	
	@Column(name = "vaccine_name",nullable = false)
	private String vaccineName;
	
	@NotNull(message = "Favor identificar o id do usuario")
	@ManyToOne
	private Patient patient = new Patient();
	
	
	@Column(name="data_aplicada", nullable = false)
	private String dataAplicada;
	
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	
	public Vaccine() {
		super();
		this.vaccineName = vaccineName;
		this.patient = patient;
		this.dataAplicada = dataAplicada;
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
}
