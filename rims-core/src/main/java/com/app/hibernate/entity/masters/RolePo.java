package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.app.hibernate.entity.core.BaseMasterEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "ROLE")
public class RolePo extends BaseMasterEntity {

	private static final long serialVersionUID = 2712743338399969863L;

	@ManyToMany(mappedBy = "roles")
	private Collection<UserPo> users;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_AUTHORITY", joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "id"))
	private Collection<AuthorityPo> authorities;

	public Collection<UserPo> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserPo> users) {
		this.users = users;
	}

	public Collection<AuthorityPo> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<AuthorityPo> authorities) {
		this.authorities = authorities;
	}

}