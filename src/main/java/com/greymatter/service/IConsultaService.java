package com.greymatter.service;

import java.util.List;

import com.greymatter.model.Consulta;
import com.greymatter.model.Examen;


public interface IConsultaService extends ICrud<Consulta, Integer> {
		
	Consulta registrarTransaccional(Consulta consulta, List<Examen> examenes) throws Exception;
}
