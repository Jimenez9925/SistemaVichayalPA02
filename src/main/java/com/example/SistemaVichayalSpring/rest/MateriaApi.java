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

import com.example.SistemaVichayalSpring.entity.Materia;
import com.example.SistemaVichayalSpring.service.MateriaService;

@RestController
@RequestMapping("/api/Materia")
public class MateriaApi {

	@Autowired
	private MateriaService service;
	
	@GetMapping()
	public ResponseEntity <List<Materia>> getAll(){
		List<Materia> materia= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(materia);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Materia> getById(@PathVariable("id") int id) {
		Materia materia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(materia);
	}
	
	
	@PostMapping
	public ResponseEntity<Materia> create(@RequestBody Materia materia) {
		Materia materiaDB=service.create(materia);
		return ResponseEntity.status(HttpStatus.CREATED).body(materiaDB);
	}
	
	@PutMapping
	public ResponseEntity<Materia> update(@RequestBody Materia materia) {
		Materia materiaDb=service.update(materia);
		return ResponseEntity.status(HttpStatus.CREATED).body(materiaDb);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
	
	
}
