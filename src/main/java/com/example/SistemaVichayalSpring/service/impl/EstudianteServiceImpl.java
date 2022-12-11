package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SistemaVichayalSpring.entity.Estudiante;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.EstudianteRepository;
import com.example.SistemaVichayalSpring.service.EstudianteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		try {
			return repository.findAll();
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Estudiante findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Estudiante create(Estudiante obj) {
		try {
		//	IngresoValidator.save(obj);
			//Guardamos
			obj.setEstado("Activo");
			return repository.save(obj);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Estudiante update(Estudiante obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public int desactivar(int id) {
		try {
			Estudiante estudianteDb= findById(id);
			if(estudianteDb==null) {
				return 0;
			}else {
				estudianteDb.setEstado("Desactivar");
				repository.save(estudianteDb);
				return 1;
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Estudiante> findByNombreContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
