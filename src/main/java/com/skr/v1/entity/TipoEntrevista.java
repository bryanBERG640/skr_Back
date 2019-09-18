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
@Table(name = "tipo_entrevista")
public class TipoEntrevista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_entrevista;
	private String descripcion;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	@OneToMany(targetEntity = Entrevista.class, mappedBy = "tipoentrevista", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Entrevista> entrevista;
	
	public TipoEntrevista() {}

	public TipoEntrevista(int id_tipo_entrevista, String descripcion, String usuario_actualiza,
			String fecha_actualizacion, Set<Entrevista> entrevista) {
		super();
		this.id_tipo_entrevista = id_tipo_entrevista;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.entrevista = entrevista;
	}

	public int getId_tipo_entrevista() {
		return id_tipo_entrevista;
	}

	public void setId_tipo_entrevista(int id_tipo_entrevista) {
		this.id_tipo_entrevista = id_tipo_entrevista;
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

	public Set<Entrevista> getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Set<Entrevista> entrevista) {
		this.entrevista = entrevista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_tipo_entrevista;
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
		TipoEntrevista other = (TipoEntrevista) obj;
		if (id_tipo_entrevista != other.id_tipo_entrevista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEntrevista [id_tipo_entrevista=" + id_tipo_entrevista + ", descripcion=" + descripcion
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion
				+ ", entrevista=" + entrevista + "]";
	}

}
