package com.greymatter.service;

import java.util.List;

import com.greymatter.model.Paciente;

public interface IPacienteService {
	Paciente registrar(Paciente p);
	Paciente modificar(Paciente p);
	List<Paciente> listar();
	Paciente listarPorId(Integer id);
	void eliminar(Integer id);
	
}
