package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.TipoAsistencia;

@Repository
public interface TipoAsistenciaRepository extends JpaRepository<TipoAsistencia, Integer>{
	public TipoAsistencia findByNombre(String nombre);
}
