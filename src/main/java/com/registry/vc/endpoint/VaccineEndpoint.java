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
import com.registry.vc.dto.VaccineResponseDto;
import com.registry.vc.dto.VaccineRequestDto;
import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;
import com.registry.vc.repository.VaccineRepository;

@RestController
@RequestMapping("/vaccine")
public class VaccineEndpoint {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	
	@GetMapping //mapeamento do verbo http nesse exemplo é get
	public List<VaccineResponseDto> listarTodos(){
		return vaccineRepository.findAll()
				.stream()
				.map(this::toVaccineDto)
				.collect(Collectors.toList());
		
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Vaccine> cadastroVacina(@Valid @RequestBody VaccineRequestDto vaccineRequestDto) {
			Vaccine vaccine = vaccineRepository.save(vaccineRequestDto.toVaccineRequest());
			URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(vaccine.getId())
	                .toUri();
			HttpHeaders responseHeaders = new HttpHeaders();
			   responseHeaders.setLocation(location);
			return new ResponseEntity<Vaccine>(vaccine, responseHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{id}")
	public List<VaccineResponseDto> listarPorId(@PathVariable Long id){
		return vaccineRepository.findById(id).stream().map(this::toVaccineDto).collect(Collectors.toList());
	}
	
	
	private VaccineResponseDto toVaccineDto(Vaccine vaccine) {
		var vaccineDto = new VaccineResponseDto();
		vaccineDto.setVaccineName(vaccine.getVaccineName());
		vaccineDto.setPatientEmail(vaccine.getPatient().getEmail());
		vaccineDto.setDataAplicada(vaccine.getDataAplicada());
		return vaccineDto;
	}
	
	
}
