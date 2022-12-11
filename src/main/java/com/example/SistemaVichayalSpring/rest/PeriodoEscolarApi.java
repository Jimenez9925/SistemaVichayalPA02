package com.example.SistemaVichayalSpring.rest;

import java.util.List;

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

import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;
import com.example.SistemaVichayalSpring.service.PeriodoEscolarService;

@RestController
@RequestMapping("/api/PeriodoEscolar")
public class PeriodoEscolarApi {

	@Autowired
	private PeriodoEscolarService service;
	
	@GetMapping()
	public ResponseEntity <List<PeriodoEscolar>> getAll(){
		List<PeriodoEscolar> periodoEscolar= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(periodoEscolar);
	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <PeriodoEscolar> getById(@PathVariable("id") int id) {
		PeriodoEscolar periodoEscolar = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(periodoEscolar);
	}
	
	
	@PostMapping
	public ResponseEntity<PeriodoEscolar> create(@RequestBody PeriodoEscolar periodoEscolar) {
		PeriodoEscolar periodoEscolarDB=service.create(periodoEscolar);
		return ResponseEntity.status(HttpStatus.CREATED).body(periodoEscolarDB);
	}
	
	@PutMapping
	public ResponseEntity<PeriodoEscolar> update(@RequestBody PeriodoEscolar periodoEscolar) {
		PeriodoEscolar periodoEscolarDB=service.update(periodoEscolar);
		return ResponseEntity.status(HttpStatus.CREATED).body(periodoEscolarDB);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
}
