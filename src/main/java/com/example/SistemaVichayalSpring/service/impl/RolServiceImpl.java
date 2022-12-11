package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import com.example.SistemaVichayalSpring.entity.Rol;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.RolRepository;
import com.example.SistemaVichayalSpring.service.RolService;
import com.example.SistemaVichayalSpring.validators.RolValidator;


@Slf4j
@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
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
	public Rol findById(int id_rol) {
		try {
			return repository.findById(id_rol).orElse(null);
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
	public Rol findByNombre(String nombre) {
		
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
	public Rol create(Rol obj) {
		try {
			// Validación
			RolValidator.save(obj);
			Rol rol = findByNombre(obj.getNombre());
			if (rol != null) {
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
	public Rol update(Rol obj) {
		try {
			RolValidator.save(obj);
			Rol rolDB=findById(obj.getId_rol());
			if(rolDB==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			Rol rol=findByNombre(obj.getNombre());
			if(rol!=null && obj.getId_rol()!=rol.getId_rol()) {
				throw new ValidateServiceException("Ya hay un registro con ese nombre");
			}
			//Actualizamos el rol
			rolDB.setNombre(obj.getNombre());
			return repository.save(rolDB);
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
	public int delete(int id_rol) {
		
		try {
			Rol rolDB= findById(id_rol);
			if(rolDB==null) {
				return 0;
			}else {
				repository.delete(rolDB);
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
