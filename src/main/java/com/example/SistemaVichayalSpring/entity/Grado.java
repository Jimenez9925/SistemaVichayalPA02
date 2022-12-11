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
@Table(name="grado") // nombre de la tabla DB
@EntityListeners(AuditingEntityListener.class)
public class Grado {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_grado;
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
	
	public int getId_grado() {
		return id_grado;
	}
	public void setId_grado(int id_grado) {
		this.id_grado = id_grado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}




