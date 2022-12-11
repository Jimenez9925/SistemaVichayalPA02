package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.Rol;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;

public class RolValidator {
	public static void save(Rol rol) {
		if(rol.getNombre()==null || rol.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(rol.getNombre().length()>15) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
