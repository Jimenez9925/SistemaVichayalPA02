package com.example.SistemaVichayalSpring.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Rol;
import com.example.SistemaVichayalSpring.service.RolService;


@RestController
@RequestMapping("/api/Rol")
public class RolApi {

	@Autowired
	private RolService service;
	
	@GetMapping()
	public ResponseEntity <List<Rol>> getAll(){
		List<Rol> rol= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(rol);
	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Rol> getById(@PathVariable("id") int id) {
		Rol rol = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(rol);
	}
	
	
	@PostMapping
	public ResponseEntity<Rol> create(@RequestBody Rol rol) {
		Rol rolDB=service.create(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDB);
	}
	
	@PutMapping
	public ResponseEntity<Rol> update(@RequestBody Rol rol) {
		Rol rolDb=service.update(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(rolDb);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
}
