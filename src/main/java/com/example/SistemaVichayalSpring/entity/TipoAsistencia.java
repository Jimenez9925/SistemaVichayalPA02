package com.example.SistemaVichayalSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tipo_asistencia") 
public class TipoAsistencia {

	@Id
	@Column(name="id_tipoasis",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipoasis; 
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
	
	
}
