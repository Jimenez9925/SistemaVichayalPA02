package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Matricula;

public interface MatriculaService {
	public List<Matricula> findAll();
	public Matricula findById(int id);
    public Matricula create(Matricula obj);
    public Matricula update(Matricula obj);
    public int desactivar(int id);
}
