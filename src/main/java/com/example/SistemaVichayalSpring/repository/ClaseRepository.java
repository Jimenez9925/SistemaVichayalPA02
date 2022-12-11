package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer>{
	//public Clase findByNombre(String nombre);
}
