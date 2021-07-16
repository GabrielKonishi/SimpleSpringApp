package com.registry.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registry.vc.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, CrudRepository<Patient, Long>{
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
	
}
