package com.greymatter.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greymatter.model.Consulta;
import com.greymatter.model.Examen;


public interface IConsultaService extends ICrud<Consulta, Integer> {
		
	Consulta registrarTransaccional(Consulta consulta, List<Examen> examenes) throws Exception;
	
	List<Consulta> buscar(String dni, String nombreCompleto);
		
	List<Consulta> buscarFecha(LocalDateTime fecha1, LocalDateTime fecha2);
}
