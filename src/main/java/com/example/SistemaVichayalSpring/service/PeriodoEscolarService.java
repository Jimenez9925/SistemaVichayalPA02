package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;

public interface PeriodoEscolarService {
	public List<PeriodoEscolar> findAll();
	public PeriodoEscolar findById(int id);
	public PeriodoEscolar findByNombreP(String nombre);
	public List<PeriodoEscolar> findByNombrePContaining(String nombre);
    public PeriodoEscolar create(PeriodoEscolar obj);
    public PeriodoEscolar update(PeriodoEscolar obj);
    public int delete(int id);
}
