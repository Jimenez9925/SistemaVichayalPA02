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
@Table(name="dia") // nombre de la tabla
@EntityListeners(AuditingEntityListener.class)
public class Dia {

	@Id
	@Column(name="id_dia",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_dia; 
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
}
