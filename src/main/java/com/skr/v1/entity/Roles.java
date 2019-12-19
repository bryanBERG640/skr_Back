package com.skr.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_roles;
	private String descripcion;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	public Roles() {
		super();
	}

	public Roles(int id_roles, String descripcion, String usuario_actualiza, String fecha_actualizacion) {
		super();
		this.id_roles = id_roles;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getid_roles() {
		return id_roles;
	}

	public void setid_roles(int id_roles) {
		this.id_roles = id_roles;
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
		result = prime * result + id_roles;
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
		Roles other = (Roles) obj;
		if (id_roles != other.id_roles)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [id_roles=" + id_roles + ", descripcion=" + descripcion + ", usuario_actualiza=" + usuario_actualiza
				+ ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}
	
	

}
