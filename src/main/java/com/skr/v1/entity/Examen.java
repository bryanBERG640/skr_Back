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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="examen")
public class Examen { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_examen;
	private String calificacion_global;
	private String observaciones;
	private String entrevistador;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_examen")
	@JsonIgnore
	private TipoExamen tipoexamen;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_cita")
	@JsonIgnore
	private Cita cita;
	
	@OneToMany(targetEntity = Seccion.class, mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Seccion> seccion;

	public Examen() {}

	public Examen(int id_examen, String calificacion_global, String observaciones, String entrevistador,
			String usuario_actualiza, String fecha_actualizacion, TipoExamen tipoexamen, Cliente cliente, Cita cita,
			Set<Seccion> seccion) {
		super();
		this.id_examen = id_examen;
		this.calificacion_global = calificacion_global;
		this.observaciones = observaciones;
		this.entrevistador = entrevistador;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.tipoexamen = tipoexamen;
		this.cliente = cliente;
		this.cita = cita;
		this.seccion = seccion;
	}

	public int getId_examen() {
		return id_examen;
	}

	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}

	public String getCalificacion_global() {
		return calificacion_global;
	}

	public void setCalificacion_global(String calificacion_global) {
		this.calificacion_global = calificacion_global;
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

	public TipoExamen getTipoexamen() {
		return tipoexamen;
	}

	public void setTipoexamen(TipoExamen tipoexamen) {
		this.tipoexamen = tipoexamen;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Set<Seccion> getSeccion() {
		return seccion;
	}

	public void setSeccion(Set<Seccion> seccion) {
		this.seccion = seccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_examen;
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
		Examen other = (Examen) obj;
		if (id_examen != other.id_examen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Examen [id_examen=" + id_examen + ", calificacion_global=" + calificacion_global + ", observaciones="
				+ observaciones + ", entrevistador=" + entrevistador + ", usuario_actualiza=" + usuario_actualiza
				+ ", fecha_actualizacion=" + fecha_actualizacion + ", tipoexamen=" + tipoexamen + ", cliente=" + cliente
				+ ", cita=" + cita + ", seccion=" + seccion + "]";
	}

	
}
