package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.PeriodoEscolarRepository;
import com.example.SistemaVichayalSpring.service.PeriodoEscolarService;
import com.example.SistemaVichayalSpring.validators.PeriodoEscolarValidator;


@Service
public class PeriodoEscolarServiceImpl implements PeriodoEscolarService{

	@Autowired
	private PeriodoEscolarRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<PeriodoEscolar> findAll() {
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
	public PeriodoEscolar findById(int id_periodoescolar) {
		try {
			return repository.findById(id_periodoescolar).orElse(null);
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
	public PeriodoEscolar findByNombreP(String nombre) {
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
	public PeriodoEscolar create(PeriodoEscolar obj) {
		try {
			// Validación
			PeriodoEscolarValidator.save(obj);
			PeriodoEscolar periodoEscolar = findByNombreP(obj.getNombre());
			if (periodoEscolar != null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			// Guardamos el rol
			obj.setEstado("Activo");
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
	public PeriodoEscolar update(PeriodoEscolar obj) {
		try {
			PeriodoEscolarValidator.save(obj);
			PeriodoEscolar periodoEscolarDB=findById(obj.getId_periodoescolar());
			if(periodoEscolarDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			PeriodoEscolar periodoEscolar=findByNombreP(obj.getNombre());
			if(periodoEscolar!=null && obj.getId_periodoescolar()!=periodoEscolar.getId_periodoescolar()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el periodo escolar
			periodoEscolarDB.setNombre(obj.getNombre());
			return repository.save(periodoEscolarDB);
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
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PeriodoEscolar> findByNombrePContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
