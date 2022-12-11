package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.Persona;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;


public class PersonaValidator {
	public static void save(Persona persona) {
		if(persona.getNombre()==null || persona.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(persona.getDni()>8) {
			throw new ValidateServiceException("El DNI es inválido");
		}
		if(persona.getNombre().length()>30) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
		if(persona.getApepat()==null || persona.getApepat().trim().isEmpty()) {
			throw new ValidateServiceException("El apellido paterno es requerido");
		}
		if(persona.getApemat()==null || persona.getApemat().trim().isEmpty()) {
			throw new ValidateServiceException("El apellido paterno es requerido");
		}
		if(persona.getCelular()>9) {
			throw new ValidateServiceException("El Celular es inválido");
		}
		
		
		
	}
}
