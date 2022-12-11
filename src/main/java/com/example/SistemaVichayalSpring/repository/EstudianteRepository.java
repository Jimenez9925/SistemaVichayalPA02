package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	public Estudiante findByNombre(String nombre);
}
 