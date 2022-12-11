package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SistemaVichayalSpring.entity.Dia;
import com.example.SistemaVichayalSpring.repository.DiaRepository;
import com.example.SistemaVichayalSpring.service.DiaService;


@Service
public class DiaServiceImpl implements DiaService{
	
	@Autowired
	private DiaRepository repository;
	
	@Override
	public List<Dia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dia findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dia findByNombreDia(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dia> findByNombreDiaContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
