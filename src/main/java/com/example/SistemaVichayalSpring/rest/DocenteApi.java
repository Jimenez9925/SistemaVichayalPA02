package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Docente;
import com.example.SistemaVichayalSpring.entity.TipoDocumento;
import com.example.SistemaVichayalSpring.service.DocenteService;
import com.example.SistemaVichayalSpring.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/Docente")
public class DocenteApi {

	 
	@Autowired
	private DocenteService service;
	
	@Autowired
	private TipoDocumentoService serviceTipoDoc;
	
	@GetMapping()
    public List<Docente> getAll(){
        return service.findAll();
    }
	
	@GetMapping(value="/{id}")
	public Docente getById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Docente> create(@RequestBody Docente docente) {
		Docente docenteDb=service.create(docente);
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteDb);
	}
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.desactivar(id);
	}
	
	 @GetMapping("/TipoDocumento")
	    public ResponseEntity<List<TipoDocumento>> getByNombre(@RequestParam String search) {	
	    	List<TipoDocumento> tipoDocumento= serviceTipoDoc.findByNombreContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(tipoDocumento);
	    }
	
	
	
	
	
}
