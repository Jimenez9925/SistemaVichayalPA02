package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer>{
	//public Horario findByNombre(String nombre);
}
