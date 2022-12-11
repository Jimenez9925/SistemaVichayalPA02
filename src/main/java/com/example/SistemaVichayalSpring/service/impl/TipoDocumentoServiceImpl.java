package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.TipoDocumento;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.TipoDocumentoRepository;
import com.example.SistemaVichayalSpring.service.TipoDocumentoService;
import com.example.SistemaVichayalSpring.validators.TipoDocumentoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

	@Autowired
	private TipoDocumentoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
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
	public TipoDocumento findById(int id_tipodoc) {
		try {
			return repository.findById(id_tipodoc).orElse(null);
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
	public TipoDocumento findByNombre(String nombre) {
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
	public TipoDocumento create(TipoDocumento obj) {
		try {
			// Validación
			TipoDocumentoValidator.save(obj);
			TipoDocumento tipoDocumento = findByNombre(obj.getNombre());
			if (tipoDocumento != null) {
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
	public TipoDocumento update(TipoDocumento obj) {
		try {
			TipoDocumentoValidator.save(obj);
			TipoDocumento TipoDocumentoDB=findById(obj.getId_tipodoc());
			if(TipoDocumentoDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			TipoDocumento tipoDocumento=findByNombre(obj.getNombre());
			if(tipoDocumento!=null && obj.getId_tipodoc()!=tipoDocumento.getId_tipodoc()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el rol
			TipoDocumentoDB.setNombre(obj.getNombre());
			return repository.save(TipoDocumentoDB);
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
	public int delete(int id_tipodoc) {
		try {
			TipoDocumento tipoDocumentoDB= findById(id_tipodoc);
			if(tipoDocumentoDB==null) {
				return 0;
			}else {
				repository.delete(tipoDocumentoDB);
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
	public List<TipoDocumento> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}}

}
