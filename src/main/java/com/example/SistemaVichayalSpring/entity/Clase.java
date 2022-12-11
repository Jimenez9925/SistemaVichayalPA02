package com.example.SistemaVichayalSpring.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "clase")
@EntityListeners(AuditingEntityListener.class)
public class Clase {

	
	@Id
	@Column(name="id_clase",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_clase; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Docente docente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_periodoescolar")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private PeriodoEscolar periodoEscolar;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Materia materia;
	
	@Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clase")
    private List<EstudianteClase> estudiante_Clase;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clase")
    private List<Horario> horario;

    public Clase(){
    	estudiante_Clase = new ArrayList<>();
    	//horario = new ArrayList<>();
    	
    }
     
   
   
}
