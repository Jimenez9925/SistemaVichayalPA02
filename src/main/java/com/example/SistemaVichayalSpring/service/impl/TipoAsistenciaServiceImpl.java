package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.TipoAsistencia;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.TipoAsistenciaRepository;
import com.example.SistemaVichayalSpring.service.TipoAsistenciaService;
import com.example.SistemaVichayalSpring.validators.TipoAsistenciaValidator;


@Service
public class TipoAsistenciaServiceImpl implements  TipoAsistenciaService{

	@Autowired
	private TipoAsistenciaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoAsistencia> findAll() {
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
	public TipoAsistencia findById(int id_tipoasis) {
		try {
			return repository.findById(id_tipoasis).orElse(null);
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
	public TipoAsistencia findByNombre(String nombre) {
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
	public TipoAsistencia create(TipoAsistencia obj) {
		try {
			// Validación
			TipoAsistenciaValidator.save(obj);
			TipoAsistencia tipoAsistencia = findByNombre(obj.getNombre());
			if (tipoAsistencia != null) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			// Guardamos el tipoAsistencia
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
	public TipoAsistencia update(TipoAsistencia obj) {
		try {
			TipoAsistenciaValidator.save(obj);
			TipoAsistencia tipoAsistenciaDB=findById(obj.getId_tipoasis());
			if(tipoAsistenciaDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			TipoAsistencia tipoAsistencia=findByNombre(obj.getNombre());
			if(tipoAsistencia!=null && obj.getId_tipoasis()!=tipoAsistencia.getId_tipoasis()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el TipoAsistencia
			tipoAsistenciaDB.setNombre(obj.getNombre());
			return repository.save(tipoAsistenciaDB);
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
	public int delete(int id_tipoasis) {
		try {
			TipoAsistencia tipoAsistenciaDB= findById(id_tipoasis);
			if(tipoAsistenciaDB==null) {
				return 0;
			}else {
				repository.delete(tipoAsistenciaDB);
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
