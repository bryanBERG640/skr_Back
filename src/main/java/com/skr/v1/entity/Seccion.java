package com.skr.v1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "seccion")
public class Seccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_seccion;
	private int no_seccion;
	private int puntaje;
	private int calificacion;
	private String observaciones;
	private String usuario_actualiza;
	private String fecha_actualizacion;	
	
	//@OneToOne(mappedBy = "examen", cascade = CascadeType.ALL)
	//@JsonIgnore

	public Seccion() {}
	
	
	
}
