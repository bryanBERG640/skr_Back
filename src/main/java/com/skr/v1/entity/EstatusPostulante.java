package com.skr.v1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="estatuspostulante")
public class EstatusPostulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idestatuspostulante")
	private int idEstatusPostulante;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="usuario_actualiza")
	private String usuario_actualiza;
	
	@JsonFormat(pattern = "aaaa-mm-dd",shape = Shape.STRING)
	@Column(name="fecha_actualizacion")
	private String fecha_actualizacion;

	public int getIdEstatusContacto() {
		return idEstatusPostulante;
	}

	public void setIdEstatusContacto(int idEstatusContacto) {
		this.idEstatusPostulante = idEstatusContacto;
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


}
