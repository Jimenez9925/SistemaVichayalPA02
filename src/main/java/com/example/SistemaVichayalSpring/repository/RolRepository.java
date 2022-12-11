package com.example.SistemaVichayalSpring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	public Rol findByNombre(String nombre);
}



