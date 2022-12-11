package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Seccion;
import com.example.SistemaVichayalSpring.service.SeccionService;

@RestController
@RequestMapping("/api/seccion")
public class SeccionApi {

	@Autowired
	private SeccionService service;
	
	@GetMapping()
	public ResponseEntity <List<Seccion>> getAll(){
		List<Seccion> seccion= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(seccion);
	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Seccion> getById(@PathVariable("id") int id) {
		Seccion seccion = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(seccion);
	}
	
	@PostMapping
	public ResponseEntity<Seccion> create(@RequestBody Seccion seccion) {
		Seccion seccionDB=service.create(seccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(seccionDB);
	}
	
	@PutMapping
	public ResponseEntity<Seccion> update(@RequestBody Seccion seccion) {
		Seccion seccionDB=service.update(seccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(seccionDB);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
	
	
	
}
