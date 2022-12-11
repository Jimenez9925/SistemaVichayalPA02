package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
	//public Matricula findByNombre(String nombre);
}
