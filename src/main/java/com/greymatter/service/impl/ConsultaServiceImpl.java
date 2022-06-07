package com.greymatter.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.greymatter.dto.ConsultaResumenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greymatter.model.Consulta;
import com.greymatter.model.Examen;
import com.greymatter.repo.IConsultaExamenRepo;
import com.greymatter.repo.IConsultaRepo;
import com.greymatter.repo.IGenericRepo;
import com.greymatter.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {
	
	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo;

	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(Consulta consulta, List<Examen> examenes) throws Exception {
		consulta.getDetalleConsulta().forEach(det -> det.setConsulta(consulta));
		
		repo.save(consulta);		
		
		examenes.forEach(e -> ceRepo.registrar(consulta.getIdConsulta(), e.getIdExamen()));
		
		return consulta;
		
	}

	@Override
	public List<Consulta> buscar(String dni, String nombreCompleto) {
		// TODO Auto-generated method stub
		return repo.buscar(dni, nombreCompleto);
	}

	@Override
	public List<Consulta> buscarFecha(LocalDateTime fecha1, LocalDateTime fecha2) {
		// TODO Auto-generated method stub
		return repo.buscarFecha(fecha1, fecha2);
	}

	@Override
	public List<ConsultaResumenDTO> listarResumen() {
		//List<Object[]>
		//[2,	"12/02/2022"]
		//[2,	"19/02/2022"]
		//[3,	"29/01/2022"]
		List<ConsultaResumenDTO> consultas = new ArrayList<>();

		repo.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});

		return consultas;
	}


}
