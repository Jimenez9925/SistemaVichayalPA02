package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Docente;

public interface DocenteService {
	public List<Docente> findAll();
	public Docente findById(int id);
	public Docente findByNombre(String nombre);
	public List<Docente> findByNombreDContaining(String nombre);
    public Docente create(Docente obj);
    public Docente update(Docente obj);
    public int desactivar(int id);
}
