package co.edu.usbcali.projectmanager.model.dao;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class UserDetailsDAO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsDAO(String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
		this.email = email;
	}

	public static UserDetailsDAO build(Userapp user) {
		List<GrantedAuthority> authorities = user.getProfile().getUserapps().stream()
				.map(profile -> new SimpleGrantedAuthority(profile.getProfile().getProfileName()))
				.collect(Collectors.toList());

		return new UserDetailsDAO(user.getUserName(), user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsDAO user = (UserDetailsDAO) o;
		return Objects.equals(userName, user.userName);
	}
}
