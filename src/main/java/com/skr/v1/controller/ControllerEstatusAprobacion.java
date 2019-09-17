package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.EstatusAprobacion;
import com.skr.v1.repository.RepositoryEstatusAprobacion;

@RestController
@RequestMapping("/aprobacion")
public class ControllerEstatusAprobacion {
	
	private RepositoryEstatusAprobacion repoAprobacion;
	
	@Autowired
	public ControllerEstatusAprobacion(RepositoryEstatusAprobacion repoAprobacion) {
		this.repoAprobacion = repoAprobacion;
	}
	
	@RequestMapping("/allEstaApro")
	public List<EstatusAprobacion> aproList(){
		return repoAprobacion.findAll();
	}

}
