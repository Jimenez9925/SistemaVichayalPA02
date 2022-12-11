package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{
	public Materia findByNombre(String nombre);
	
}
