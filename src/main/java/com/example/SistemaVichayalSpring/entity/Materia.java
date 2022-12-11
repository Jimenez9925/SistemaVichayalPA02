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
@Table(name="materia")
@EntityListeners(AuditingEntityListener.class)
public class Materia {

	@Id
	@Column(name="id_materia",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_materia; 
	@Column(name="nombre", nullable = false, length = 50,unique=true)
	private String nombre; 
	
	
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
