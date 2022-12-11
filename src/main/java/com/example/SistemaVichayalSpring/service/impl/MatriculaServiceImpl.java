package com.example.SistemaVichayalSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SistemaVichayalSpring.entity.Matricula;
import com.example.SistemaVichayalSpring.exceptions.GeneralServiceException;
import com.example.SistemaVichayalSpring.exceptions.NoDataFoundException;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;
import com.example.SistemaVichayalSpring.repository.MatriculaRepository;
import com.example.SistemaVichayalSpring.service.MatriculaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository repository;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
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
	public Matricula findById(int id) {
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
	@Transactional
	public Matricula create(Matricula obj) {
		try {
			//	IngresoValidator.save(obj);
				//Guardamos
				
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
	public Matricula update(Matricula obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int desactivar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
