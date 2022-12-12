package com.example.SistemaVichayalSpring.service;

import java.util.List;

import com.example.SistemaVichayalSpring.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(int id);
	public Usuario findByEmail(String email);
	public List<Usuario> findByEmailContaining(String email);
    public Usuario create(Usuario obj);
    public Usuario update(Usuario obj);
    public int desactivar(int id);
}
