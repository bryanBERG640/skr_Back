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
@Table(name = "aprobacion")
public class EstatusAprobacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estatus_aprobacion;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	
	public EstatusAprobacion() {}
	
	public EstatusAprobacion(int id_estatus_aprobacion, String descripcion, String usuario_actualiza,
			Date fecha_actualizacion) {
		super();
		this.id_estatus_aprobacion = id_estatus_aprobacion;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getId_estatus_aprobacion() {
		return id_estatus_aprobacion;
	}

	public void setId_estatus_aprobacion(int id_estatus_aprobacion) {
		this.id_estatus_aprobacion = id_estatus_aprobacion;
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
		result = prime * result + id_estatus_aprobacion;
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
		EstatusAprobacion other = (EstatusAprobacion) obj;
		if (id_estatus_aprobacion != other.id_estatus_aprobacion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstatusAprobacion [id_estatus_aprobacion=" + id_estatus_aprobacion + ", descripcion=" + descripcion
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + "]";
	}

}
