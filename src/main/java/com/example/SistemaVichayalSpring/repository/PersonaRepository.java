package com.example.SistemaVichayalSpring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	//public Persona findByNombre(String nombre);
	//public List<Persona> findByNombreContaining(String nombre);
}
