package com.greymatter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


	@Override
	public Page<Paciente> listarPageable(Pageable page) {
		return repo.findAll(page);
	}
}
