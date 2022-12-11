package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer>{
	public Docente findByNombre(String nombre);
}
