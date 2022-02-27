package com.greymatter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greymatter.model.Paciente;
import com.greymatter.repo.IPacienteRepo;
import com.greymatter.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {
	
	@Autowired
	private IPacienteRepo repo;
	
	@Override
	public Paciente registrar(Paciente p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public Paciente modificar(Paciente p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Paciente listarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	

}
