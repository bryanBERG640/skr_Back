package com.skr.v1.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "estatus_titulacion")
public class EstatusTitulacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estatus_titulacion;
	private String descripcion;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	public EstatusTitulacion() {}

	public EstatusTitulacion(int id_estatus_titulacion, String descripcion, String usuario_actualiza,
			String fecha_actualizacion) {
		super();
		this.id_estatus_titulacion = id_estatus_titulacion;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getId_estatus_titulacion() {
		return id_estatus_titulacion;
	}

	public void setId_estatus_titulacion(int id_estatus_titulacion) {
		this.id_estatus_titulacion = id_estatus_titulacion;
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

	public String getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(String fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_estatus_titulacion;
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
		EstatusTitulacion other = (EstatusTitulacion) obj;
		if (id_estatus_titulacion != other.id_estatus_titulacion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstatusTitulacion [id_estatus_titulacion=" + id_estatus_titulacion + ", descripcion=" + descripcion
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}

	
}