package com.skr.v1.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "estatus_cv")
public class EstatusCV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estatus_cv;
	private String descripcion;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	public EstatusCV() {}

	public EstatusCV(int id_estatus_cv, String descripcion, String usuario_actualiza, String fecha_actualizacion,
			Set<PostulanteComplemento> postulantecomplemento) {
		super();
		this.id_estatus_cv = id_estatus_cv;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getId_estatus_cv() {
		return id_estatus_cv;
	}

	public void setId_estatus_cv(int id_estatus_cv) {
		this.id_estatus_cv = id_estatus_cv;
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
		result = prime * result + id_estatus_cv;
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
		EstatusCV other = (EstatusCV) obj;
		if (id_estatus_cv != other.id_estatus_cv)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstatusCV [id_estatus_cv=" + id_estatus_cv + ", descripcion=" + descripcion + ", usuario_actualiza="
				+ usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + ", postulantecomplemento="
				+ "]";
	}
}