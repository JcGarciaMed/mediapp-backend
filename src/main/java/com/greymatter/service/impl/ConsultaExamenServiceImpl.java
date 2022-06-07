package com.greymatter.service.impl;

import com.greymatter.model.ConsultaExamen;
import com.greymatter.repo.IConsultaExamenRepo;
import com.greymatter.service.IConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService {

    @Autowired
    private IConsultaExamenRepo repo;

    @Override
    public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
        return repo.listarExamenesPorConsulta(idconsulta);
    }
}
