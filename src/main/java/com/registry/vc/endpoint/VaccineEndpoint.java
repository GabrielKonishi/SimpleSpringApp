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

import com.registry.vc.dto.PatientDto;
import com.registry.vc.dto.VaccineDto;
import com.registry.vc.dto.VaccineRequestDto;
import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;
import com.registry.vc.repository.VaccineRepository;

@RestController
@RequestMapping("/vaccine")
public class VaccineEndpoint {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping //mapeamento do verbo http nesse exemplo é get
	public List<VaccineDto> listarTodos(){
		return vaccineRepository.findAll()
				.stream()
				.map(this::toVaccineDto)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Vaccine> cadastroVacina(@Valid @RequestBody VaccineRequestDto vaccineRequestDto) {
		Vaccine vaccine = vaccineRepository.save(vaccineRequestDto.toVaccineRequest());
		return new ResponseEntity("vacina cadastrada com sucesso", HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public String deletarVaccine(@PathVariable Long id) {
		vaccineRepository.deleteById(id);
		return "excluido com sucesso";
	}
	
	private VaccineDto toVaccineDto(Vaccine vaccine) {
		return modelMapper.map(vaccine, VaccineDto.class);
		
	}
	
}
