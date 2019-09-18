package com.skr.v1.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estatus_postulante")
public class EstatusPostulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estatus_postulante;
	private String descripcion;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	@OneToMany(targetEntity = PostulanteB.class, mappedBy = "estatuspostulante", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<PostulanteB> postulanteb;	
	
	public EstatusPostulante() {}

	public EstatusPostulante(int id_estatus_postulante, String descripcion, String usuario_actualiza,
			String fecha_actualizacion, Set<PostulanteB> postulanteb) {
		super();
		this.id_estatus_postulante = id_estatus_postulante;
		this.descripcion = descripcion;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.postulanteb = postulanteb;
	}

	public int getId_estatus_postulante() {
		return id_estatus_postulante;
	}

	public void setId_estatus_postulante(int id_estatus_postulante) {
		this.id_estatus_postulante = id_estatus_postulante;
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

	public Set<PostulanteB> getPostulanteb() {
		return postulanteb;
	}

	public void setPostulanteb(Set<PostulanteB> postulanteb) {
		this.postulanteb = postulanteb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_estatus_postulante;
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
		EstatusPostulante other = (EstatusPostulante) obj;
		if (id_estatus_postulante != other.id_estatus_postulante)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstatusPostulante [id_estatus_postulante=" + id_estatus_postulante + ", descripcion=" + descripcion
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion
				+ ", postulanteb=" + postulanteb + "]";
	}
}
