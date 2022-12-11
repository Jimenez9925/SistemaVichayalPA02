package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer>{
	public Grado findByNombre(String nombre);
}


