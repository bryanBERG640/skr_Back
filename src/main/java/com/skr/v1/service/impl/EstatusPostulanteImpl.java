package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.EstatusPostulante;
import com.skr.v1.repository.RepositoryEstatusPostulante;

public class EstatusPostulanteImpl {
	
	private RepositoryEstatusPostulante repoEstatusPostulante;
	
	@Autowired
	public EstatusPostulanteImpl(RepositoryEstatusPostulante repoEstatusPostulante) {
		this.repoEstatusPostulante = repoEstatusPostulante;
	}
	
	@Autowired List<EstatusPostulante> estatusPostulanteList() {
		return repoEstatusPostulante.findAll();
	}

}
