package com.example.SistemaVichayalSpring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@Table(name = "estudiante_clase")
public class EstudianteClase {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estudiante_clase; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Estudiante estudiante;
	

}
