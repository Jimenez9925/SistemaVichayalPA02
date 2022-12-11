package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;


import com.example.SistemaVichayalSpring.entity.Seccion;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.SeccionRepository;
import com.example.SistemaVichayalSpring.service.SeccionService;
import com.example.SistemaVichayalSpring.validators.SeccionValidator;


@Slf4j
@Service
public class SeccionServiceImpl implements SeccionService {

	@Autowired
	private SeccionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Seccion> findAll() {
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
	public Seccion findById(int id_seccion) {
		try {
			return repository.findById(id_seccion).orElse(null);
		} catch (ValidateServiceException | NoDataFoundException e) {
		//	Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
		//	Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Seccion findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (ValidateServiceException | NoDataFoundException e) {
			//Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
		//	Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Seccion create(Seccion obj) {
		try {
			// Validación
			SeccionValidator.save(obj);
			Seccion seccion = findByNombre(obj.getNombre());
			if (seccion != null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			// Guardamos el rol
			return repository.save(obj);
		
		} catch (ValidateServiceException | NoDataFoundException e) {
			//Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			//Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Seccion update(Seccion obj) {
		try {
			SeccionValidator.save(obj);
			Seccion seccionDB=findById(obj.getId_seccion());
			if(seccionDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Seccion seccion=findByNombre(obj.getNombre());
			if(seccion!=null && obj.getId_seccion()!=seccion.getId_seccion()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el rol
			seccionDB.setNombre(obj.getNombre());
			return repository.save(seccionDB);
		} catch (ValidateServiceException | NoDataFoundException e) {
		//	Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			//Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public int delete(int id_seccion) {
		
		try {
			Seccion seccionDB= findById(id_seccion);
			if(seccionDB==null) {
				return 0;
			}else {
				repository.delete(seccionDB);
				return 1;}
		} catch (ValidateServiceException | NoDataFoundException e) {
			//Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			//Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
