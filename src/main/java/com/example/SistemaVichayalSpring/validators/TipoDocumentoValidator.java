package com.example.SistemaVichayalSpring.validators;

import com.example.SistemaVichayalSpring.entity.TipoDocumento;
import com.example.SistemaVichayalSpring.exceptions.ValidateServiceException;

public class TipoDocumentoValidator {
	public static void save(TipoDocumento tipoDocumento) {
		if(tipoDocumento.getNombre()==null || tipoDocumento.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido");
		}
		if(tipoDocumento.getNombre().length()>15) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
	}
}
