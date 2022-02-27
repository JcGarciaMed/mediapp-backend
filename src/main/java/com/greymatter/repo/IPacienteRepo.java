package com.greymatter.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greymatter.model.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {
	
}
