package com.example.SistemaVichayalSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.EstudianteClase;

@Repository
public interface EstudianteClaseRepository extends JpaRepository<EstudianteClase, Integer>{

}
