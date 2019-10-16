package com.skr.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skr.v1.entity.Empresa;

@Repository
public interface RepositoryEmpresa extends JpaRepository<Empresa, Integer>{

}
