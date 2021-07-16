package com.registry.vc.endpoint;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.registry.vc.dto.PatientResponseDto;
import com.registry.vc.dto.PatientRequestDto;
import com.registry.vc.model.Patient;
import com.registry.vc.repository.PatientRepository;

@RestController 
@RequestMapping("/patient") 
public class PatientEndpoint {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping // mapeamento do verbo http. Nesse exemplo é o método get
	public List<PatientResponseDto> listarTodos() {
		
		List<PatientResponseDto> map  = patientRepository.findAll().stream().map(this::toPatientDto).collect(Collectors.toList());
		
		return map;
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Patient> adicionar(@Valid @RequestBody PatientRequestDto patientRequestDto, BindingResult result, RedirectAttributes attributes) throws Exception {
		if(cpfExist(patientRequestDto.getCpf()) == true && emailExist(patientRequestDto.getEmail()) == true) {
			System.out.println("cpf ou email duplicado");
			throw new Exception();
		}
		Patient patient = patientRepository.save(patientRequestDto.toPatientRequest());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getId())
				.toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<Patient>(patient, responseHeaders, HttpStatus.CREATED);
	}
	
	
	@GetMapping(path = "/{id}")
	public List<PatientResponseDto> listarPorId(@PathVariable Long id){
		return patientRepository.findById(id).stream().map(this::toPatientDto).collect(Collectors.toList());
	}
	
	@DeleteMapping
	public void deleteAll() {
		patientRepository.deleteAll();
	}
	
	
	
	private PatientResponseDto toPatientDto(Patient patient) {
		var patientDto = new PatientResponseDto();
		patientDto.setName(patient.getName());
		patientDto.setEmail(patient.getEmail());
		patientDto.setCpf(patient.getCpf());
		patientDto.setDataNascimento(patient.getDataNascimento());
		return patientDto;

	}
	
	public boolean cpfExist( String cpf ) {
        return patientRepository.existsByCpf( cpf );
    }
	
	public boolean emailExist( String email ) {
        return patientRepository.existsByEmail( email );
    }
	
	
	
	
}
