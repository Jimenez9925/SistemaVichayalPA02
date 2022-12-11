package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Dia;

public interface DiaService {
	public List<Dia> findAll();
	public Dia findById(int id);
	public Dia findByNombreDia(String nombre);
	public List<Dia> findByNombreDiaContaining(String nombre);
   
}
