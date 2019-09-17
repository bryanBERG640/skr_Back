package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.EstatusAprobacion;
import com.skr.v1.repository.RepositoryEstatusAprobacion;
import com.skr.v1.service.AprobacionService;

public class AproImpl implements AprobacionService {
	
	private RepositoryEstatusAprobacion repoAprobacion;

	@Autowired
	public AproImpl(RepositoryEstatusAprobacion repoAprobacion) {
		this.repoAprobacion = repoAprobacion;
	}
	
	@Autowired
	public List<EstatusAprobacion> aproList(){
		return repoAprobacion.findAll();
	}

}
