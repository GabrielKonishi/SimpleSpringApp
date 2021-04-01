package com.registry.vc.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.registry.vc.model.Patient;
import com.registry.vc.model.Vaccine;
import com.registry.vc.repository.VaccineRepository;

@RestController
@RequestMapping("/vaccine")
public class VaccineEndpoint {
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@GetMapping //mapeamento do verbo http nesse exemplo é get
	public List<Vaccine> listar(){
		return vaccineRepository.findAll();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastroVacina(@Valid @RequestBody Vaccine vaccine) {
		vaccineRepository.save(vaccine);
		return "Vacina Cadastrada com sucesso";
	}
	
	
	
	@DeleteMapping("/{id}")
	public String deletarVaccine(@PathVariable Long id) {
		vaccineRepository.deleteById(id);
		return "excluido com sucesso";
	}
	
}
