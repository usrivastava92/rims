package com.app.hibernate.core.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2583108868867866016L;

	@Id
	@GenericGenerator(name = "sequencePerEntityGenerator", strategy = "com.app.hibernate.config.CustomSequenceGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "prefer_sequence_per_entity", value = "true"),
			@org.hibernate.annotations.Parameter(name = "sequence_per_entity_suffix", value = "_seq"),
			@org.hibernate.annotations.Parameter(name = "initial_value", value = "100") })
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencePerEntityGenerator")
	private Long id;

	public Long getId() {
		return id;
	}

	@Column(name = "CREATION_TIME_STAMP")
	private Date creationTimeStamp;

	@Column(name = "LAST_UPDATED_TIME_STAMP")
	private Date lastUpdatedTimeStamp;

	@PrePersist
	private void setCreationTimeStamp() {
		creationTimeStamp = new Date();
	}

	@PreUpdate
	private void setLastUpdatedTimeStamp() {
		lastUpdatedTimeStamp = new Date();
	}

	public Date getCreationTimeStamp() {
		return creationTimeStamp;
	}

	public Date getLastUpdatedTimeStamp() {
		return lastUpdatedTimeStamp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (creationTimeStamp == null) {
			if (other.creationTimeStamp != null)
				return false;
		} else if (!creationTimeStamp.equals(other.creationTimeStamp)) {
			return false;
		}
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastUpdatedTimeStamp == null) {
			if (other.lastUpdatedTimeStamp != null) {
				return false;
			}
		} else if (!lastUpdatedTimeStamp.equals(other.lastUpdatedTimeStamp)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTimeStamp == null) ? 0 : creationTimeStamp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdatedTimeStamp == null) ? 0 : lastUpdatedTimeStamp.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return super.getClass().getName() + ":" + getId();
	}
}
