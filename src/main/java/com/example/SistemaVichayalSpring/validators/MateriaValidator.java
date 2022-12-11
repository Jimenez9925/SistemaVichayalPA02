package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.Materia;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;

public class MateriaValidator {
	public static void save(Materia materia) {
		if(materia.getNombre()==null || materia.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(materia.getNombre().length()>50) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
