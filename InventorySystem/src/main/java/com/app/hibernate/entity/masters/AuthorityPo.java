package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseMasterEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AUTHORITY")
public class AuthorityPo extends BaseMasterEntity {

	private static final long serialVersionUID = -8849579649376561789L;

	@JsonIgnore
	@ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
	private Collection<RolePo> roles;

	public AuthorityPo() {
		super();
	}

	public AuthorityPo(String name) {
		setName(name);
	}

	public Collection<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolePo> roles) {
		this.roles = roles;
	}

}
