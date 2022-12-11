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
@Table(name = "horario")
public class Horario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_horario; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dia")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Dia dia;
	
	
    private String horainicio;
    private String horafin;
	
}
