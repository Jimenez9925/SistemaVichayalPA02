package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Estudiante;
import com.example.SistemaVichayalSpring.entity.TipoDocumento;
import com.example.SistemaVichayalSpring.service.EstudianteService;
import com.example.SistemaVichayalSpring.service.TipoDocumentoService;

 

@RestController
@RequestMapping("/api/Estudiante")
public class EstudianteApi {

	@Autowired
	private EstudianteService service;
	
	@Autowired
	private TipoDocumentoService serviceTipoDoc; 
	
	@GetMapping()
    public ResponseEntity <List<Estudiante>> getAll(){
		List<Estudiante> estudiante= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(estudiante);
    }
	
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Estudiante> getById(@PathVariable("id") int id) {
		Estudiante estudiante = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(estudiante);
	
	}
	
	@PostMapping
	public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante) {
		Estudiante estudianteDb=service.create(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudianteDb);
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
