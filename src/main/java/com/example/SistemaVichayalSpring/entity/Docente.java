package com.example.SistemaVichayalSpring.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name="docente")
@EntityListeners(AuditingEntityListener.class)
public class Docente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_docente; 
		
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipodoc")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private TipoDocumento tipoDocumento;
	
	
	@Column(name="dni", nullable = false, length = 11,unique=true)
	private int dni;
	@Column(name="nombre", nullable = false, length = 30)
	private String nombre;
	@Column(name="apepat", nullable = false, length = 30)
	private String apepat;
	@Column(name="apemat", nullable = false, length = 30)
	private String apemat;
	@Column(name="celular", nullable = false, length = 9)
	private int celular;
	
	
	@Column(name="created_at",nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(name="updated_at",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(length = 20) 
    private String estado;
	
}
