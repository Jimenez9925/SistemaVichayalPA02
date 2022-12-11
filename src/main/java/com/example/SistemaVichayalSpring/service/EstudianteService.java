package com.example.SistemaVichayalSpring.service;

import java.util.List;
import com.example.SistemaVichayalSpring.entity.Estudiante;

public interface EstudianteService {
	public List<Estudiante> findAll();
	public Estudiante findById(int id);
	public Estudiante findByNombre(String nombre);
	public List<Estudiante> findByNombreContaining(String nombre);
    public Estudiante create(Estudiante obj);
    public Estudiante update(Estudiante obj);
    public int desactivar(int id);
}
