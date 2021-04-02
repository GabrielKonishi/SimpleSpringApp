package com.registry.vc.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.registry.vc.dto.VaccineDto;
import com.registry.vc.model.Vaccine;


//A classe foi criada com a anotação @Configuration para ser possível que o Spring gerencie a injeção de dependencia através do @Autowired
@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
	
		return modelMapper;
	}

}
