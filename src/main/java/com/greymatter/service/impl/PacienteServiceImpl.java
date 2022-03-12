package com.greymatter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.greymatter.model.Paciente;
import com.greymatter.repo.IGenericRepo;
import com.greymatter.repo.IPacienteRepo;
import com.greymatter.service.IPacienteService;


@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {
	
	@Autowired
	private IPacienteRepo repo;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
