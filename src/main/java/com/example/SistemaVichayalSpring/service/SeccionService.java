package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Seccion;


public interface SeccionService {
	public List<Seccion> findAll();
	public Seccion findById(int id);
	public Seccion findByNombre(String nombre);
    public Seccion create(Seccion obj);
    public Seccion update(Seccion obj);
    public int delete(int id);
}
