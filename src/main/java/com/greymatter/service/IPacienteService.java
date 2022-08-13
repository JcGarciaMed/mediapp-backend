package com.greymatter.service;

import com.greymatter.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacienteService extends ICrud<Paciente, Integer> {
    Page<Paciente> listarPageable(Pageable page);
	
}
