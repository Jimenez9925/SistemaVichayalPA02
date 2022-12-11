package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Grado;

public interface GradoService {
	public List<Grado> findAll();
	public Grado findById(int id);
	public Grado findByNombreG(String nombre);
	public List<Grado> findByNombreGContaining(String nombre);
    public Grado create(Grado obj);
    public Grado update(Grado obj);
    public int delete(int id);
}
