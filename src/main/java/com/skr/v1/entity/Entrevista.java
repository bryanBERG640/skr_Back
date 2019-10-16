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
@Table(name = "entrevista")
public class Entrevista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_entrevista;
	private String observaciones;
	private String entrevistador;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_entrevista")
	@JsonIgnore
	private TipoEntrevista tipoentrevista;
	
	@ManyToOne
	@JoinColumn(name="id_cita")
	@JsonIgnore
	private Cita cita;
	
	public Entrevista() {}

	public Entrevista(int id_entrevista, String observaciones, String entrevistador, String usuario_actualiza,
			String fecha_actualizacion, TipoEntrevista tipoentrevista, Cita cita) {
		super();
		this.id_entrevista = id_entrevista;
		this.observaciones = observaciones;
		this.entrevistador = entrevistador;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.tipoentrevista = tipoentrevista;
		this.cita = cita;
	}

	public int getId_entrevista() {
		return id_entrevista;
	}

	public void setId_entrevista(int id_entrevista) {
		this.id_entrevista = id_entrevista;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(String entrevistador) {
		this.entrevistador = entrevistador;
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

	public TipoEntrevista getTipoentrevista() {
		return tipoentrevista;
	}

	public void setTipoentrevista(TipoEntrevista tipoentrevista) {
		this.tipoentrevista = tipoentrevista;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_entrevista;
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
		Entrevista other = (Entrevista) obj;
		if (id_entrevista != other.id_entrevista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrevista [id_entrevista=" + id_entrevista + ", observaciones=" + observaciones + ", entrevistador="
				+ entrevistador + ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion="
				+ fecha_actualizacion + ", tipoentrevista=" + tipoentrevista + ", cita=" + cita + "]";
	}

}
