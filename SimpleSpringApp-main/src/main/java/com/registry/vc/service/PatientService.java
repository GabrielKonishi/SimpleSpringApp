package com.registry.vc.service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.registry.vc.dto.PatientRequestDto;
import com.registry.vc.dto.PatientResponseDto;
import com.registry.vc.model.Patient;
import com.registry.vc.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public List<PatientResponseDto> listAll() {
		List<PatientResponseDto> map  = patientRepository.findAll().stream().map(this::toPatientDto).collect(Collectors.toList());
		return map;
	}
	
	public ResponseEntity<Patient> patientRegistry(@Valid @RequestBody PatientRequestDto patientRequestDto) throws Exception {
		String requestCpf = patientRequestDto.getCpf();
		String requestEmail = patientRequestDto.getEmail();
		String message = null;
		if(cpfExist(requestCpf)) {
			message = "cpf: " + requestCpf + " Already Exist";	
			if(emailExist(requestEmail)) {
				message = message + " & Email: " + requestEmail + " Already Exist";	
			}
		}else if(emailExist(requestEmail)) {
			message = "Email: " + requestEmail + " Already Exist";	
		}
		
		if(cpfExist(requestCpf) == true || emailExist(requestEmail) == true) {
			throw new Exception(message);
		}
		Patient patient = patientRepository.save(patientRequestDto.toPatientRequest());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getId())
				.toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}
	

	public List<PatientResponseDto> findByCpf(String cpf) {
		return patientRepository.findByCpf(cpf).stream().map(this::toPatientDto).collect(Collectors.toList());
	}
	
	
	public boolean cpfExist( String cpf ) {
        return patientRepository.existsByCpf( cpf );
    }
	
	public boolean emailExist( String email ) {
        return patientRepository.existsByEmail( email );
    }
	
	private PatientResponseDto toPatientDto(Patient patient) {
		var patientDto = new PatientResponseDto();
		patientDto.setName(patient.getName());
		patientDto.setEmail(patient.getEmail());
		patientDto.setCpf(patient.getCpf());
		patientDto.setDataNascimento(patient.getDataNascimento());
		return patientDto;

	}


}
