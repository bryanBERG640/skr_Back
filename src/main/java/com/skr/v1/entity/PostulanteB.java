package com.skr.v1.entity;

import java.io.File;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="postulante_b")
public class PostulanteB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_postulante_b;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String celular;
	private String telefono;
	private String correo;
	private String observaciones;
	private File cv;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	
	@ManyToOne
	@JoinColumn(name="id_estatus_postulante")
	private EstatusPostulante estatuspostulante;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;
	
	/*@OneToMany(targetEntity = Cita.class, mappedBy = "postulanteb", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Cita> cita;	
	
	@OneToOne(mappedBy = "postulanteb", cascade = CascadeType.ALL)
	@JsonIgnore
	private PostulanteComplemento postulanteComplemento;*/
	
	public PostulanteB() {}

	public PostulanteB(int id_postulante_b, String nombre, String apellido1, String apellido2, String celular,
			String telefono, String correo, String observaciones, File cv, String usuario_actualiza,
			String fecha_actualizacion, EstatusPostulante estatuspostulante, Perfil perfil) {
		super();
		this.id_postulante_b = id_postulante_b;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.celular = celular;
		this.telefono = telefono;
		this.correo = correo;
		this.observaciones = observaciones;
		this.cv = cv;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.estatuspostulante = estatuspostulante;
		this.perfil = perfil;
	}

	public int getId_postulante_b() {
		return id_postulante_b;
	}

	public void setId_postulante_b(int id_postulante_b) {
		this.id_postulante_b = id_postulante_b;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
		this.cv = cv;
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

	public EstatusPostulante getEstatuspostulante() {
		return estatuspostulante;
	}

	public void setEstatuspostulante(EstatusPostulante estatuspostulante) {
		this.estatuspostulante = estatuspostulante;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_postulante_b;
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
		PostulanteB other = (PostulanteB) obj;
		if (id_postulante_b != other.id_postulante_b)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostulanteB [id_postulante_b=" + id_postulante_b + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", celular=" + celular + ", telefono=" + telefono + ", correo=" + correo
				+ ", observaciones=" + observaciones + ", cv=" + cv + ", usuario_actualiza=" + usuario_actualiza
				+ ", fecha_actualizacion=" + fecha_actualizacion + ", estatuspostulante=" + estatuspostulante
				+ ", perfil=" + perfil + "]";
	}

	

	/*public PostulanteB(int id_postulante_b, String nombre, String apellido1, String apellido2, String celular,
			String telefono, String correo, String observaciones, File cv, String usuario_actualiza,
			String fecha_actualizacion, EstatusPostulante estatuspostulante, Perfil perfil, Set<Cita> cita,
			PostulanteComplemento postulanteComplemento) {
		super();
		this.id_postulante_b = id_postulante_b;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.celular = celular;
		this.telefono = telefono;
		this.correo = correo;
		this.observaciones = observaciones;
		this.cv = cv;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.estatuspostulante = estatuspostulante;
		this.perfil = perfil;
		this.cita = cita;
		this.postulanteComplemento = postulanteComplemento;
	}

	public int getId_postulante_b() {
		return id_postulante_b;
	}

	public void setId_postulante_b(int id_postulante_b) {
		this.id_postulante_b = id_postulante_b;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
		this.cv = cv;
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

	public EstatusPostulante getEstatuspostulante() {
		return estatuspostulante;
	}

	public void setEstatuspostulante(EstatusPostulante estatuspostulante) {
		this.estatuspostulante = estatuspostulante;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<Cita> getCita() {
		return cita;
	}

	public void setCita(Set<Cita> cita) {
		this.cita = cita;
	}

	public PostulanteComplemento getPostulanteComplemento() {
		return postulanteComplemento;
	}

	public void setPostulanteComplemento(PostulanteComplemento postulanteComplemento) {
		this.postulanteComplemento = postulanteComplemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_postulante_b;
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
		PostulanteB other = (PostulanteB) obj;
		if (id_postulante_b != other.id_postulante_b)
			return false;
		return true;
	} 

	@Override
	public String toString() {
		return "PostulanteB [id_postulante_b=" + id_postulante_b + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", celular=" + celular + ", telefono=" + telefono + ", correo=" + correo
				+ ", observaciones=" + observaciones + ", cv=" + cv + ", usuario_actualiza=" + usuario_actualiza
				+ ", fecha_actualizacion=" + fecha_actualizacion + ", estatuspostulante=" + estatuspostulante
				+ ", perfil=" + perfil + ", cita=" + cita + ", postulanteComplemento=" + postulanteComplemento + "]";
	}*/
	
}
