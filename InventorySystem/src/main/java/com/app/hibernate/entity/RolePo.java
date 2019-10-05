package com.app.hibernate.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "ROLE")
public class RolePo extends BaseEntity {

	private static final long serialVersionUID = 2712743338399969863L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Collection<UserPo> users;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_AUTHORITY", joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "id"))
	private Collection<AuthorityPo> authorities;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "RolePo [id=" + id + ", name=" + name + ", authorities=" + authorities + ", creationTimeStamp="
				+ creationTimeStamp + ", lastUpdatedTimeStamp=" + lastUpdatedTimeStamp + "]";
	}

}