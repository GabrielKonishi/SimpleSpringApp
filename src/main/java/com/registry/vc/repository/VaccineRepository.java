package com.registry.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registry.vc.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{

}
