package com.example.SistemaVichayalSpring.entity;

import javax.persistence.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table(name="grado")
@EntityListeners(AuditingEntityListener.class)
public class Grado {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_grado;
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
	@Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_grado")
    private List<Seccion> seccio;
	
	public Grado(){
		seccio = new ArrayList<>(); 
    }
}




