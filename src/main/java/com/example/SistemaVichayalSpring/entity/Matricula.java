package com.example.SistemaVichayalSpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="matricula")
@EntityListeners(AuditingEntityListener.class)
public class Matricula {

	@Id
	@Column(name="id_materia",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_materia; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Estudiante estudiante;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_periodoescolar")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private PeriodoEscolar periodoEscolar;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Grado grado;
	
	@Column(name="created_at",nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(precision=6,scale=2,nullable=false)
    private Double  precio;
}
