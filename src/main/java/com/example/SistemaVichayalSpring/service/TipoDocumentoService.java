package com.example.SistemaVichayalSpring.service;

import java.util.List;


import com.example.SistemaVichayalSpring.entity.TipoDocumento;

public interface TipoDocumentoService {
	public List<TipoDocumento> findAll();
	public TipoDocumento findById(int id);
	public TipoDocumento findByNombre(String nombre);
	public List<TipoDocumento> findByNombreContaining(String nombre);
    public TipoDocumento create(TipoDocumento obj);
    public TipoDocumento update(TipoDocumento obj);
    public int delete(int id);
}
