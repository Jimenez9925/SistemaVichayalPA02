package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.TipoAsistencia;

public interface TipoAsistenciaService {
	public List<TipoAsistencia> findAll();
	public TipoAsistencia findById(int id);
	public TipoAsistencia findByNombre(String nombre);
    public TipoAsistencia create(TipoAsistencia obj);
    public TipoAsistencia update(TipoAsistencia obj);
    public int delete(int id);
}
