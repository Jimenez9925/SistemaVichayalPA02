package com.example.SistemaVichayalSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SistemaVichayalSpring.entity.Dia;
import com.example.SistemaVichayalSpring.service.DiaService;

@RestController
@RequestMapping("/api/Dia")
public class DiaApi {

	@Autowired
	private DiaService service;
	
	
	@GetMapping()
    public ResponseEntity <List<Dia>> getAll(){
		List<Dia> dia= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(dia);
    }
	

	@GetMapping(value="/{id}")
	public ResponseEntity <Dia> getById(@PathVariable("id") int id) {
		Dia dia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(dia);
	
	}
}
