package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.TipoAsistencia;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;

public class TipoAsistenciaValidator {
	public static void save(TipoAsistencia tipoAsistencia) {
		if(tipoAsistencia.getNombre()==null || tipoAsistencia.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(tipoAsistencia.getNombre().length()>15) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
