package com.app.hibernate.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AUTHORITY")
public class AuthorityPo extends BaseEntity {

	private static final long serialVersionUID = -8849579649376561789L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
	private Collection<RolePo> roles;

	public AuthorityPo() {
		super();
	}

	public AuthorityPo(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<RolePo> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolePo> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "AuthorityPo [id=" + id + ", name=" + name + ", creationTimeStamp=" + creationTimeStamp
				+ ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AuthorityPo other = (AuthorityPo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
