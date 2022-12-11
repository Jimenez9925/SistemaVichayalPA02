package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.SistemaVichayalSpring.entity.Grado;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.GradoRepository;
import com.example.SistemaVichayalSpring.service.GradoService;
import com.example.SistemaVichayalSpring.validators.GradoValidator;


@Service
public class GradoServiceImpl implements GradoService{

	
	@Autowired
	private GradoRepository repository;
	
	
	@Override
	@Transactional(readOnly = true) 
	public List<Grado> findAll() {
		try {
			return repository.findAll();
		} catch (ValidateServiceException | NoDataFoundException e) {
		
		//	log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
		//	log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findById(int id_grado) {
		try {
			return repository.findById(id_grado).orElse(null);
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
	public Grado findByNombreG(String nombre) {
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
	public Grado create(Grado obj) {
		try {
			// Validación
			GradoValidator.save(obj);
			Grado grado = findByNombreG(obj.getNombre());
			if (grado != null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			// Guardamos el grado
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
	public Grado update(Grado obj) {
		try {
			GradoValidator.save(obj);
			Grado gradoDB=findById(obj.getId_grado());
			if(gradoDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Grado grado=findByNombreG(obj.getNombre());
			if(grado!=null && obj.getId_grado()!=grado.getId_grado()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el grado
			gradoDB.setNombre(obj.getNombre());
			return repository.save(gradoDB);
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
	public int delete(int id_grado) {
		try {
			Grado gradoDB= findById(id_grado);
			if(gradoDB==null) {
				return 0;
			}else {
				repository.delete(gradoDB);
				return 1;}
		} catch (ValidateServiceException | NoDataFoundException e) {
			//Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			//Log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Grado> findByNombreGContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
