package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.PeriodoEscolar;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;

public class PeriodoEscolarValidator {
	public static void save(PeriodoEscolar periodoEscolar) {
		//validar que la fecha (inicio y fin) sea el año actual 
		if(periodoEscolar.getNombre()==null || periodoEscolar.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(periodoEscolar.getNombre().length()>15) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
