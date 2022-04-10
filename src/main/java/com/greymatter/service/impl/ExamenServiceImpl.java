package com.greymatter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greymatter.model.Examen;
import com.greymatter.repo.IExamenRepo;
import com.greymatter.repo.IGenericRepo;
import com.greymatter.service.IExamenService;


@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {
	
	@Autowired
	private IExamenRepo repo;

	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	
}
