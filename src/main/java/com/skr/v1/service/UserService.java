package com.skr.v1.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skr.v1.entity.Roles;
import com.skr.v1.entity.Usuario;
import com.skr.v1.repository.RepositoryRoles;
import com.skr.v1.repository.RepositoryUser;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private RepositoryUser repo;
	
	@Autowired
	private RepositoryRoles repoRol;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario us=repo.findByUsuario(username);
		
		List<Roles> role=repoRol.findAll();
		
		Set<GrantedAuthority> grantList= new HashSet<GrantedAuthority>();
		for(Roles roles: role)
		{
			GrantedAuthority grantedAuthority= new SimpleGrantedAuthority(roles.getDescripcion());
			grantList.add(grantedAuthority);
		}
		
		UserDetails userDet=(UserDetails) new User(us.getUsuario(), us.getpassword(), grantList);
		
		return userDet;
	}

	
}
