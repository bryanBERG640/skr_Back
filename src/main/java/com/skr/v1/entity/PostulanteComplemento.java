package com.skr.v1.entity;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "postulante_c")
public class PostulanteComplemento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_postulante_c;
	private String fecha_nacimiento;
	private int edad;
	private String curp;
	private String rfc;
	private int pretencion_economica;
	private String certificaciones;
	private String tiempo_experiencia;
	private int acuerdo_economico;
	private File foto_perfil;
	private String usuario_actualiza;
	private String fecha_actualizacion;
	
	
	@OneToOne
    @JoinColumn(name = "id_postulante_b")
	private PostulanteB postulanteb;
	
	@ManyToOne
    @JoinColumn(name = "id_escuela")
	private Escuela escuela;

	@ManyToOne
    @JoinColumn(name = "id_estatus_titulacion")
	private EstatusTitulacion estatustitulacion;
	
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;
	
	@ManyToOne
    @JoinColumn(name = "id_sexo")
	private Sexo sexo;

	@ManyToOne
    @JoinColumn(name = "id_estatus_cv")
	private EstatusCV estatuscv;
	
	@ManyToOne
    @JoinColumn(name = "id_estatus_aprobacion")
	private EstatusAprobacion estatusprobacion;

	public PostulanteComplemento() {}

	public PostulanteComplemento(int id_postulante_c, String fecha_nacimiento, int edad, String curp, String rfc,
			int pretencion_economica, String certificaciones, String tiempo_experiencia, int acuerdo_economico,
			File foto_perfil, String usuario_actualiza, String fecha_actualizacion, PostulanteB postulanteb,
			Escuela escuela, EstatusTitulacion estatustitulacion, Carrera carrera, Sexo sexo, EstatusCV estatuscv,
			EstatusAprobacion estatusprobacion) {
		super();
		this.id_postulante_c = id_postulante_c;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.curp = curp;
		this.rfc = rfc;
		this.pretencion_economica = pretencion_economica;
		this.certificaciones = certificaciones;
		this.tiempo_experiencia = tiempo_experiencia;
		this.acuerdo_economico = acuerdo_economico;
		this.foto_perfil = foto_perfil;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualizacion = fecha_actualizacion;
		this.postulanteb = postulanteb;
		this.escuela = escuela;
		this.estatustitulacion = estatustitulacion;
		this.carrera = carrera;
		this.sexo = sexo;
		this.estatuscv = estatuscv;
		this.estatusprobacion = estatusprobacion;
	}

	public int getId_postulante_c() {
		return id_postulante_c;
	}

	public void setId_postulante_c(int id_postulante_c) {
		this.id_postulante_c = id_postulante_c;
	}

	public String getFecha_nacimiento() {
		
//		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
//		System.err.println(dt1.format(this.fecha_nacimiento));
	
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public int getPretencion_economica() {
		return pretencion_economica;
	}

	public void setPretencion_economica(int pretencion_economica) {
		this.pretencion_economica = pretencion_economica;
	}

	public String getCertificaciones() {
		return certificaciones;
	}

	public void setCertificaciones(String certificaciones) {
		this.certificaciones = certificaciones;
	}

	public String getTiempo_experiencia() {
		return tiempo_experiencia;
	}

	public void setTiempo_experiencia(String tiempo_experiencia) {
		this.tiempo_experiencia = tiempo_experiencia;
	}

	public int getAcuerdo_economico() {
		return acuerdo_economico;
	}

	public void setAcuerdo_economico(int acuerdo_economico) {
		this.acuerdo_economico = acuerdo_economico;
	}

	public File getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(File foto_perfil) {
		this.foto_perfil = foto_perfil;
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

	public PostulanteB getPostulanteb() {
		return postulanteb;
	}

	public void setPostulanteb(PostulanteB postulanteb) {
		this.postulanteb = postulanteb;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public EstatusTitulacion getEstatustitulacion() {
		return estatustitulacion;
	}

	public void setEstatustitulacion(EstatusTitulacion estatustitulacion) {
		this.estatustitulacion = estatustitulacion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstatusCV getEstatuscv() {
		return estatuscv;
	}

	public void setEstatuscv(EstatusCV estatuscv) {
		this.estatuscv = estatuscv;
	}

	public EstatusAprobacion getEstatusprobacion() {
		return estatusprobacion;
	}

	public void setEstatusprobacion(EstatusAprobacion estatusprobacion) {
		this.estatusprobacion = estatusprobacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_postulante_c;
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
		PostulanteComplemento other = (PostulanteComplemento) obj;
		if (id_postulante_c != other.id_postulante_c)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostulanteComplemento [id_postulante_c=" + id_postulante_c + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", edad=" + edad + ", curp=" + curp + ", rfc=" + rfc + ", pretencion_economica="
				+ pretencion_economica + ", certificaciones=" + certificaciones + ", tiempo_experiencia="
				+ tiempo_experiencia + ", acuerdo_economico=" + acuerdo_economico + ", foto_perfil=" + foto_perfil
				+ ", usuario_actualiza=" + usuario_actualiza + ", fecha_actualizacion=" + fecha_actualizacion
				+ ", postulanteb=" + postulanteb + ", escuela=" + escuela + ", estatustitulacion=" + estatustitulacion
				+ ", carrera=" + carrera + ", sexo=" + sexo + ", estatuscv=" + estatuscv + ", estatusprobacion="
				+ estatusprobacion + "]";
	}
}