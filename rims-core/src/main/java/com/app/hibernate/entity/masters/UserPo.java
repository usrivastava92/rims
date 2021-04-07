package com.app.hibernate.entity.masters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.hibernate.entity.core.BaseMasterEntity;
import com.app.hibernate.entity.UserAdditionalInfoPo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
public class UserPo extends BaseMasterEntity implements UserDetails {

	private static final long serialVersionUID = -3788850886108135694L;

	@Column(name = "USERNAME", unique = true)
	private String username;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ADD_INFO_FK")
	private UserAdditionalInfoPo userAdditionalInfoPo;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_ENABLED")
	private boolean userEnabled;
	@Column(name = "ACCOUNT_EXPIRED")
	private boolean accountExpired;
	@Column(name = "ACCOUNT_LOCKED")
	private boolean accountLocked;
	@Column(name = "CREDENTIALS_EXPIRED")
	private boolean credentialsExpired;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_USERS", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"))
	private Collection<RolePo> roles;

	public Collection<RolePo> getRoles() {
		return roles;
	}

	public UserAdditionalInfoPo getUserAdditionalInfoPo() {
		return userAdditionalInfoPo;
	}

	public String getEmail() {
		return email;
	}

	public void setUserAdditionalInfoPo(UserAdditionalInfoPo userAdditionalInfoPo) {
		this.userAdditionalInfoPo = userAdditionalInfoPo;
	}

	public void setRoles(Collection<RolePo> roles) {
		this.roles = roles;
	}

	public String isEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public boolean isAccountExpired() {
		return accountExpired;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getGrantedAuthorities(getAuthorities(this.roles));
	}

	private List<String> getAuthorities(Collection<RolePo> roles) {

		List<String> privileges = new ArrayList<>();
		List<AuthorityPo> collection = new ArrayList<>();
		for (RolePo role : roles) {
			collection.addAll(role.getAuthorities());
		}
		for (AuthorityPo item : collection) {
			privileges.add(item.getName());
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (String authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority));
		}
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !this.accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !this.credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.userEnabled;
	}

}
