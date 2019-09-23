package com.skr.v1.entity;

import java.sql.Date;
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
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_perfil;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	
	public Perfil() {}

	public Perfil(int id_perfil, String descripcion, String usuario_actualiza, Date fecha_actualizacion,
			Set<PostulanteB> postulanteb) {
		super();
		this.id_perfil = id_perfil;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
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
		result = prime * result + id_perfil;
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
		Perfil other = (Perfil) obj;
		if (id_perfil != other.id_perfil)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [id_perfil=" + id_perfil + ", descripcion=" + descripcion + ", usuario_actualiza="
				+ usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + ", postulanteb=" + "]";
	}
}
