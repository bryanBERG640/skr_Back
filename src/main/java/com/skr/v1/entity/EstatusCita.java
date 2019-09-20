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
@Table(name = "estatus_cita")
public class EstatusCita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estatus_cita;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;

	public EstatusCita() {}

	public EstatusCita(int id_estatus_cita, String descripcion, String usuario_actualiza, Date fecha_actualizacion,
			Set<Cita> cita) {
		super();
		this.id_estatus_cita = id_estatus_cita;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}


	public int getId_estatus_cita() {
		return id_estatus_cita;
	}


	public void setId_estatus_cita(int id_estatus_cita) {
		this.id_estatus_cita = id_estatus_cita;
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
		result = prime * result + id_estatus_cita;
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
		EstatusCita other = (EstatusCita) obj;
		if (id_estatus_cita != other.id_estatus_cita)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EstatusCita [id_estatus_cita=" + id_estatus_cita + ", descripcion=" + descripcion
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion
				+"]";
	}
}
