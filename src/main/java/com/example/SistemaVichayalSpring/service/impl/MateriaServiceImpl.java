package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.Materia;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.MateriaRepository;
import com.example.SistemaVichayalSpring.service.MateriaService;
import com.example.SistemaVichayalSpring.validators.MateriaValidator;


@Service
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	private MateriaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Materia> findAll() {
		try {
			return repository.findAll();
		} catch (ValidateServiceException | NoDataFoundException e) {
			//Log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
		//	log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Materia findById(int id_materia) {
		try {
			return repository.findById(id_materia).orElse(null);
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
	public Materia findByNombre(String nombre) {
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
	public Materia create(Materia obj) {
		try {
			// Validación
			MateriaValidator.save(obj);
			Materia materia = findByNombre(obj.getNombre());
			if (materia != null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			// Guardamos el materia
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
	public Materia update(Materia obj) {
		try {
			MateriaValidator.save(obj);
			Materia materiaDB=findById(obj.getId_materia());
			if(materiaDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Materia materia=findByNombre(obj.getNombre());
			if(materia!=null && obj.getId_materia()!=materia.getId_materia()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos la materia
			materiaDB.setNombre(obj.getNombre());
			return repository.save(materiaDB);
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
	public int delete(int id_materia) {
		try {
			Materia materiaDB= findById(id_materia);
			if(materiaDB==null) {
				return 0;
			}else {
				repository.delete(materiaDB);
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
	public List<Materia> findByNombreContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
