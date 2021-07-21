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
import com.registry.vc.service.PatientService;

@RestController 
@RequestMapping("/patient") 
public class PatientEndpoint {

	@Autowired
	private PatientService patientService;
	
	
	@GetMapping // mapeamento do verbo http. Nesse exemplo é o método get
	public List<PatientResponseDto> listarTodos() {
		List<PatientResponseDto> map  = patientService.listAll();
		return map;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Patient> adicionar(@RequestBody PatientRequestDto patientRequestDto) throws Exception {
		patientService.patientRegistry(patientRequestDto);
		return new ResponseEntity<Patient>(HttpStatus.CREATED);
	}
	
	
	@GetMapping(path = "/{id}")
	public List<PatientResponseDto> listarPorId(@PathVariable Long id){
		return patientService.findById(id);
	}
		
	
}
