package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
	public Seccion findByNombre(String nombre);
}
