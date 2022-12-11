package com.example.SistemaVichayalSpring.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
@Table(name="rol") // nombre de la tabla
@EntityListeners(AuditingEntityListener.class)
public class Rol {
 
	@Id
	@Column(name="id_rol",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_rol; 
	@Column(name="nombre", nullable = false, length = 15,unique=true)
	private String nombre;
	
	@Column(name="created_at",nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(name="updated_at",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	 
	
}
