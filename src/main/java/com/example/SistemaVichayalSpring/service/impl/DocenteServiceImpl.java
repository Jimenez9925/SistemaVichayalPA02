package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.Docente;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.DocenteRepository;
import com.example.SistemaVichayalSpring.service.DocenteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	private DocenteRepository repository;

	
	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll() {
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
	public Docente findById(int id) {
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
	@Transactional(readOnly = true)
	public Docente findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Docente create(Docente obj) {
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
	@Transactional
	public Docente update(Docente obj) {
		try {
			//IngresoValidator.save(obj);
			Docente docenteDb=repository.findById(obj.getId_docente()).orElse(null);
			if(docenteDb==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			
			//Actualizamos la categoría
			//docenteDb.setPersona(obj.getPersona());
			return repository.save(docenteDb);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public int desactivar(int id) {
		try {
			Docente docenteDb= findById(id);
			if(docenteDb==null) {
				return 0;
			}else {
				docenteDb.setEstado("Desactivar");
				repository.save(docenteDb);
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
	public List<Docente> findByNombreDContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
