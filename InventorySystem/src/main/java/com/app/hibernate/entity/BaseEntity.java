package com.app.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2583108868867866016L;

	@Column(name = "CREATION_TIME_STAMP")
	protected Date creationTimeStamp;

	@Column(name = "LAST_UPDATED_TIME_STAMP")
	protected Date lastUpdatedTimeStamp;

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

}
