package com.example.SistemaVichayalSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SistemaVichayalSpring.entity.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{
	public TipoDocumento findByNombre(String nombre);
	public List<TipoDocumento> findByNombreContaining(String nombre);
}
