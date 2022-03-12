package com.greymatter.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.greymatter.model.Medico;
import com.greymatter.repo.IGenericRepo;
import com.greymatter.repo.IMedicoRepo;
import com.greymatter.service.IMedicoService;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService {
	
	@Autowired
	private IMedicoRepo repo;

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
}
