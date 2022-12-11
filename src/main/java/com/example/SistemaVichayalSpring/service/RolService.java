package com.example.SistemaVichayalSpring.service;

import java.util.List;
import com.example.SistemaVichayalSpring.entity.Rol;


public interface RolService {
	public List<Rol> findAll();
	public Rol findById(int id);
	public Rol findByNombre(String nombre);
    public Rol create(Rol obj);
    public Rol update(Rol obj);
    public int delete(int id);
}
