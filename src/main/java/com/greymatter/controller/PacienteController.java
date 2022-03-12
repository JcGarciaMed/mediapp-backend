package com.greymatter.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.greymatter.dto.PacienteDTO;
import com.greymatter.exception.ModeloNotFoundException;
import com.greymatter.model.Paciente;
import com.greymatter.service.IPacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> listar() throws Exception{
		List<PacienteDTO> lista = service.listar().stream().map(p->mapper.map(p, PacienteDTO.class)).collect(Collectors.toList());			
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<PacienteDTO> listarPorId(@PathVariable("id") Integer id) throws Exception{
		
		Paciente paciente= service.listarPorId(id);
		
		if(paciente == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		PacienteDTO dto = mapper.map(paciente, PacienteDTO.class);
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}	
	
//	@PostMapping
//	public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) throws Exception {
//		Paciente paciente= service.registrar(p);
//		return new ResponseEntity<>(paciente,HttpStatus.CREATED);
//	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody PacienteDTO dto) throws Exception {
		Paciente p= mapper.map(dto, Paciente.class);
		Paciente obj = service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}	
	
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody PacienteDTO dto) throws Exception {
		Paciente obj= service.listarPorId(dto.getIdPaciente());		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdPaciente());
		}		
		Paciente p = mapper.map(dto, Paciente.class);
		Paciente pac= service.modificar(p);
		return new ResponseEntity<>(pac,HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Paciente paciente= service.listarPorId(id);		
		if(paciente == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}		
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}		
}
