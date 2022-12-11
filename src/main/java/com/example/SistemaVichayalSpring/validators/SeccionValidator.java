package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.Seccion;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;


public class SeccionValidator {

	public static void save(Seccion seccion) {
		if(seccion.getNombre()==null || seccion.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(seccion.getNombre().length()>15) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
	
}
