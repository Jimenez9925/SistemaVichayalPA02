package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.TipoAsistencia;
import com.example.SistemaVichayalSpring.service.TipoAsistenciaService;

@RestController
@RequestMapping("/api/TipoAsistencia")
public class TipoAsistenciaApi {

	@Autowired
	private TipoAsistenciaService service;
	
	@GetMapping()
	public ResponseEntity <List<TipoAsistencia>> getAll(){
		List<TipoAsistencia> tipoAsistencia= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(tipoAsistencia);
	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <TipoAsistencia> getById(@PathVariable("id") int id) {
		TipoAsistencia tipoAsistencia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(tipoAsistencia);
	}
	
	
	@PostMapping
	public ResponseEntity<TipoAsistencia> create(@RequestBody TipoAsistencia tipoAsistencia) {
		TipoAsistencia tipoAsistencialDB=service.create(tipoAsistencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAsistencialDB);
	}
	
	@PutMapping
	public ResponseEntity<TipoAsistencia> update(@RequestBody TipoAsistencia tipoAsistencia) {
		TipoAsistencia tipoAsistencialDB=service.update(tipoAsistencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAsistencialDB);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
}
