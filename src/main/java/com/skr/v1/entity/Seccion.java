package com.skr.v1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private float puntaje;
	private float calificacion;
	private String observaciones;
	private String usuario_actualiza;
	private String fecha_actualizacion;	
	
	@ManyToOne
	@JoinColumn(name="id_examen")
	@JsonIgnore
	private Examen examen;
	
	public Seccion() {}

	public Seccion(int id_seccion, int no_seccion, float puntaje, float calificacion, String observaciones,
			String usuario_actualiza, String fecha_actualizacion, Examen examen) {
		super();
		this.id_seccion = id_seccion;
		this.no_seccion = no_seccion;
		this.puntaje = puntaje;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.examen = examen;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public int getNo_seccion() {
		return no_seccion;
	}

	public void setNo_seccion(int no_seccion) {
		this.no_seccion = no_seccion;
	}

	public float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_seccion;
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
		Seccion other = (Seccion) obj;
		if (id_seccion != other.id_seccion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seccion [id_seccion=" + id_seccion + ", no_seccion=" + no_seccion + ", puntaje=" + puntaje
				+ ", calificacion=" + calificacion + ", observaciones=" + observaciones + ", usuario_actualiza="
				+ usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion + ", examen=" + examen + "]";
	}
	
}
