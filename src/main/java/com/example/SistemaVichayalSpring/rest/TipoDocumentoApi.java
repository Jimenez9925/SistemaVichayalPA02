package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.TipoDocumento;
import com.example.SistemaVichayalSpring.service.TipoDocumentoService;


@RestController
@RequestMapping("/api/TipoDocumento")
public class TipoDocumentoApi {

	@Autowired
	private TipoDocumentoService service;
	
	@GetMapping()
	public ResponseEntity <List<TipoDocumento>> getAll(){
		List<TipoDocumento> rol= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(rol);	
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <TipoDocumento> getById(@PathVariable("id") int id) {
		TipoDocumento tipoDocumento = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(tipoDocumento);
	}
	
	@PostMapping
	public ResponseEntity<TipoDocumento> create(@RequestBody TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoDB=service.create(tipoDocumento);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoDB);
	}
	
	@PutMapping
	public ResponseEntity<TipoDocumento> update(@RequestBody TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoDB=service.update(tipoDocumento);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoDB);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
		
	}
	
	
	
	
	
	
	
	
}
