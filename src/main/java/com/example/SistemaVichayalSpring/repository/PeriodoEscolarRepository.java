package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;

@Repository
public interface PeriodoEscolarRepository extends JpaRepository<PeriodoEscolar, Integer>{
	public PeriodoEscolar findByNombre(String nombre);
	
}
