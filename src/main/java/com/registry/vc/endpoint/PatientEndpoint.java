package com.registry.vc.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.registry.vc.dto.PatientResponse;
import com.registry.vc.model.Patient;
import com.registry.vc.repository.PatientRepository;


//A anotação @RestController define a classe como uma classe que vai receber requisições REST
//A anotação @RequestMapping Define a url que quando for requisitada chamara o metodo
@RestController
@RequestMapping("/patient")
public class PatientEndpoint {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping //mapeamento do verbo http nesse exemplo é get
	public List<PatientResponse> listarTodos(){
		return patientRepository.findAll()
				.stream()
				.map(this::toPatientDto)
				.collect(Collectors.toList());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity adicionar(@Valid @RequestBody Patient patient){
		patientRepository.save(patient);
		//return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
		return new ResponseEntity("Paciente cadastrado com sucesso", HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletarPatient(@PathVariable Long id) {
		patientRepository.deleteById(id);
		return new ResponseEntity("Paciente excluido com sucesso", HttpStatus.OK);
		
	}
	
	private PatientResponse toPatientDto(Patient patient) {
		return modelMapper.map(patient, PatientResponse.class);
		
	}
	
	
}
