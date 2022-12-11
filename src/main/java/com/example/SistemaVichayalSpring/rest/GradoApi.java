package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Grado;
import com.example.SistemaVichayalSpring.service.GradoService;

@RestController
@RequestMapping("/api/grado")
public class GradoApi {

	@Autowired
	private GradoService service;
	
	
	@GetMapping()
	public ResponseEntity <List<Grado>> getAll(){
		List<Grado> grado= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(grado);	
	}	
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Grado> getById(@PathVariable("id") int id) {
		Grado grado = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(grado);
	}
	
	@PostMapping
	public ResponseEntity<Grado> create(@RequestBody Grado grado) {
		Grado gradoDB=service.create(grado);
		return ResponseEntity.status(HttpStatus.CREATED).body(gradoDB);
	}
	
	@PutMapping
	public ResponseEntity<Grado> update(@RequestBody Grado grado) {
		Grado gradoDB=service.update(grado);
		return ResponseEntity.status(HttpStatus.CREATED).body(gradoDB);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
	
	
}
