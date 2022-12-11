package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.Grado;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;


public class GradoValidator {
	public static void save(Grado grado) {
		if(grado.getNombre()==null || grado.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(grado.getNombre().length()>15) { 
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
