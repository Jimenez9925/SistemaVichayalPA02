package com.example.SistemaVichayalSpring.entity;

import javax.persistence.*;

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
@Table(name="seccion") // nombre de la tabla
@EntityListeners(AuditingEntityListener.class)


public class Seccion {

	@Id
	@Column(name="id_seccion",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_seccion; 
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	

}
