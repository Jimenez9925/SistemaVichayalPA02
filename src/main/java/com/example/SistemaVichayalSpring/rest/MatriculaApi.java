package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.service.MatriculaService;
import com.example.SistemaVichayalSpring.service.PeriodoEscolarService;
import com.example.SistemaVichayalSpring.entity.Estudiante;
import com.example.SistemaVichayalSpring.entity.Grado;
import com.example.SistemaVichayalSpring.entity.Matricula;
import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;
import com.example.SistemaVichayalSpring.service.EstudianteService;
import com.example.SistemaVichayalSpring.service.GradoService;

@RestController
@RequestMapping("/api/Matricula")
public class MatriculaApi {

	@Autowired
	private MatriculaService service;
	
	@Autowired
	private EstudianteService serviceEstudiante; 
	
	@Autowired
	private PeriodoEscolarService servicePeriodoEscolar; 
	
	@Autowired
	private GradoService serviceGrado;
	
	
	@GetMapping()
    public List<Matricula> getAll(){
        return service.findAll();
    }
	
	
	
	@GetMapping(value="/{id}")
    public Matricula getById(@PathVariable("id") int id) {
        return service.findById(id);
    }
	

	 @PostMapping
	    public ResponseEntity<Matricula> save(@RequestBody Matricula matricula){    	 
		 Matricula matriculaCreate=service.create(matricula);
	    	return ResponseEntity.status(HttpStatus.CREATED).body(matriculaCreate);
	    }
	
	
	
	
	
	
	 @GetMapping("/Estudiante")
	    public ResponseEntity<List<Estudiante>> getByNombre(@RequestParam String search) {	
	    	List<Estudiante> estudiante= serviceEstudiante.findByNombreContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(estudiante);
	    }
	
	 @GetMapping("/PeriodoEscolar")
	    public ResponseEntity<List<PeriodoEscolar>> getByNombreP(@RequestParam String search) {	
	    	List<PeriodoEscolar> periodoEscolar= servicePeriodoEscolar.findByNombrePContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(periodoEscolar);
	    }
	 
	 
	 @GetMapping("/Grado")
	    public ResponseEntity<List<Grado>> findByNombreG(@RequestParam String search) {	
	    	List<Grado> grado= serviceGrado.findByNombreGContaining(search);
	        return ResponseEntity.status(HttpStatus.OK).body(grado);
	    }
	
}
