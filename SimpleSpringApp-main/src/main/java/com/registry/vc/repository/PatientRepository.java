package com.registry.vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.registry.vc.dto.PatientResponseDto;
import com.registry.vc.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, CrudRepository<Patient, Long>{
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
	List<Patient> findByCpf(String cpf);
}
