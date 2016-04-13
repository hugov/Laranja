package br.com.decimal.laranja.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.decimal.laranja.model.Role;

public class ControleAcessoController {

	private Object principal = null;
	private UserDetails userDetails = null;
	private String username = null;
	private Collection<? extends GrantedAuthority> authorities = null;

	public String getUsername() {
		authentication();
		return username;
	}

	public Boolean isAuthorizedBy(String auth) {
		Boolean retorno = Boolean.FALSE;
		authentication();
		if (principal != null && principal instanceof UserDetails) {
			if (authorities.contains(new SimpleGrantedAuthority(auth))) {
				retorno = Boolean.TRUE;
			}
		}
		return retorno;
	}

	public List<Role> getRoles() {
		authentication();
		List<Role> roles = new ArrayList<>();
		if (principal != null && principal instanceof UserDetails) {
			for (GrantedAuthority authority : authorities) {
				roles.add(new Role(authority.getAuthority()));
			}
		}
		return roles;
	}

	public void authentication() {
		principal = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (principal != null && principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
			username = userDetails.getUsername();
			authorities = userDetails.getAuthorities();
		}
	}

}
