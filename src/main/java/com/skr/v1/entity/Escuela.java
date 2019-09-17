package com.skr.v1.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "escuela")
public class Escuela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_escuela;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	

	public Escuela() {}


	public Escuela(int id_escuela, String descripcion, String usuario_actualiza, Date fecha_actualizacion) {
		super();
		this.id_escuela = id_escuela;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}


	public int getId_escuela() {
		return id_escuela;
	}


	public void setId_escuela(int id_escuela) {
		this.id_escuela = id_escuela;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getUsuario_actualiza() {
		return usuario_actualiza;
	}


	public void setUsuario_actualiza(String usuario_actualiza) {
		this.usuario_actualiza = usuario_actualiza;
	}


	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}


	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_escuela;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escuela other = (Escuela) obj;
		if (id_escuela != other.id_escuela)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Escuela [id_escuela=" + id_escuela + ", descripcion=" + descripcion + ", usuario_actualiza="
				+ usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + ", postulantecomplemento="
				+ "]";
	}
}