package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Materia;

public interface MateriaService {
	public List<Materia> findAll();
	public Materia findById(int id);
	public Materia findByNombre(String nombre);
	public List<Materia> findByNombreContaining(String nombre);
    public Materia create(Materia obj);
    public Materia update(Materia obj);
    public int delete(int id);
}
