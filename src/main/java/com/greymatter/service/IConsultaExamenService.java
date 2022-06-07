package com.greymatter.service;

import com.greymatter.model.ConsultaExamen;

import java.util.List;

public interface IConsultaExamenService {

    List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
