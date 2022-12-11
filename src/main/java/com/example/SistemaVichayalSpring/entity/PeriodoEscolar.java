package com.example.SistemaVichayalSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter 
@Entity
@Table(name="periodo_escolar") 
@EntityListeners(AuditingEntityListener.class)
public class PeriodoEscolar {

	@Id
	@Column(name="id_periodoescolar",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_periodoescolar; 
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
	
	//verificar que tipo de dato es fecha
	@Column(name="fecha_inicio", nullable = false, length = 15)
	private String fecha_inicio;
	@Column(name="fecha_fin", nullable = false, length = 15)
	private String fecha_fin;
	@Column(length = 20)
    private String estado;
	

}
