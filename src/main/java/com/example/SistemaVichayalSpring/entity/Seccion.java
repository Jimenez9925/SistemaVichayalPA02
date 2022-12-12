package com.example.SistemaVichayalSpring.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Setter
@Getter
@Table(name="seccion")


public class Seccion {

	@Id
	@Column(name="id_seccion",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_seccion; 
	
	@Column(name="nombreG", nullable = false, length = 15,unique=true)
	private String nombreG;
	

}
