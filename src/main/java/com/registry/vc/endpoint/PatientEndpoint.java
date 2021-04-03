package com.registry.vc.endpoint;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.registry.vc.dto.PatientResponseDto;
import com.registry.vc.dto.PatientRequestDto;
import com.registry.vc.model.Patient;
import com.registry.vc.repository.PatientRepository;


//A anotação @RestController define a classe como uma classe que vai receber requisições REST
//A anotação @RequestMapping Define a url que quando for requisitada chamara o metodo
@RestController
@RequestMapping("/patient")
public class PatientEndpoint {
	
	@Autowired
	private PatientRepository patientRepository;
	
	//@Autowired
	//private ModelMapper modelMapper;
	
	@GetMapping //mapeamento do verbo http nesse exemplo é get
	public List<PatientResponseDto> listarTodos(){
		return patientRepository.findAll()
				.stream()
				.map(this::toPatientDto)
				.collect(Collectors.toList());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Patient> adicionar(@Valid @RequestBody PatientRequestDto patientRequestDto){
		Patient patient = patientRepository.save(patientRequestDto.toPatientRequest());
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.getId())
                .toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.setLocation(location);
		return new ResponseEntity<Patient>(patient, responseHeaders, HttpStatus.CREATED);
		
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
