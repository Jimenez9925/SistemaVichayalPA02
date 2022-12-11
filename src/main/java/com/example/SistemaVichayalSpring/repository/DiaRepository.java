package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Dia;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Integer>{
	public Dia findByNombre(String nombre);
}
