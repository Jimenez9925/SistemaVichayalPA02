package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Clase;
import com.example.SistemaVichayalSpring.entity.Docente;
import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;
import com.example.SistemaVichayalSpring.entity.Materia;
import com.example.SistemaVichayalSpring.service.ClaseService;
import com.example.SistemaVichayalSpring.service.DocenteService;
import com.example.SistemaVichayalSpring.service.MateriaService;
import com.example.SistemaVichayalSpring.service.PeriodoEscolarService;

@RestController
@RequestMapping("/api/Clase")
public class ClaseApi {

	@Autowired
	private ClaseService service;
	
	@Autowired
	private DocenteService serviceDocente; 
	
	@Autowired
	private MateriaService serviceMateria; 
	
	@Autowired
	private PeriodoEscolarService servicePeriodoEscolar; 
	
	@GetMapping()
    public List<Clase> getAll(){
        return service.findAll();
    }
	
	
	
	@GetMapping(value="/{id}")
    public Clase getById(@PathVariable("id") int id) {
        return service.findById(id);
    }
	

	 @PostMapping
	    public ResponseEntity<Clase> save(@RequestBody Clase clase){    	 
		 Clase claseCreate=service.create(clase);
	    	return ResponseEntity.status(HttpStatus.CREATED).body(claseCreate);
	    }
	
	
	
	
	@GetMapping("/Docente")
    public ResponseEntity<List<Docente>> getByNombreD(@RequestParam String search) {	
    	List<Docente> docente= serviceDocente.findByNombreDContaining(search);
        return ResponseEntity.status(HttpStatus.OK).body(docente);
    }
	
	 @GetMapping("/Materia")
	    public ResponseEntity<List<Materia>> getByNombre(@RequestParam String search) {	
	    	List<Materia> materia= serviceMateria.findByNombreContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(materia);
	    }
	
	 @GetMapping("/PeriodoEscolar")
	    public ResponseEntity<List<PeriodoEscolar>> getByNombreP(@RequestParam String search) {	
	    	List<PeriodoEscolar> periodoEscolar= servicePeriodoEscolar.findByNombrePContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(periodoEscolar);
	    }
	
	
}
