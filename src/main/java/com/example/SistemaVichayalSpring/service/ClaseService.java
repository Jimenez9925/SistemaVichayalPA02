package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Clase;

public interface ClaseService {

	public List<Clase> findAll();
	public Clase findById(int id);
	
    public Clase create(Clase obj);
    public Clase update(Clase obj);
  
}
