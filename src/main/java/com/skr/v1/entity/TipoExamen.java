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
@Table(name = "tipo_examen")
public class TipoExamen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_examen;
	private String examen_tipo;
	private String descripcion;
	private String usuario_actualiza;
	private Date fecha_actualizacion;
	
	public TipoExamen() {}

	public TipoExamen(int id_tipo_examen, String examen_tipo, String decripcion, String usuario_actualiza,
			Date fecha_actualizacion) {
		super();
		this.id_tipo_examen = id_tipo_examen;
		this.examen_tipo = examen_tipo;
		this.descripcion = decripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public int getId_tipo_examen() {
		return id_tipo_examen;
	}

	public void setId_tipo_examen(int id_tipo_examen) {
		this.id_tipo_examen = id_tipo_examen;
	}

	public String getExamen_tipo() {
		return examen_tipo;
	}

	public void setExamen_tipo(String examen_tipo) {
		this.examen_tipo = examen_tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String decripcion) {
		this.descripcion = decripcion;
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
		result = prime * result + id_tipo_examen;
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
		TipoExamen other = (TipoExamen) obj;
		if (id_tipo_examen != other.id_tipo_examen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoExamen [id_tipo_examen=" + id_tipo_examen + ", examen_tipo=" + examen_tipo + ", descripcion="
				+ descripcion + ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion="
				+ fecha_actualizacion + "]";
	}

}
