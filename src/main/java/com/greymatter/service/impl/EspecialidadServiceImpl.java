package com.greymatter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greymatter.model.Especialidad;
import com.greymatter.repo.IEspecialidadRepo;
import com.greymatter.repo.IGenericRepo;
import com.greymatter.service.IEspecialidadService;



@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {
	
	@Autowired
	private IEspecialidadRepo repo;

	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		return repo;
	}


}
