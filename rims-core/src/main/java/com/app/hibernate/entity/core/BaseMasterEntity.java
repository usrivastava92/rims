package com.app.hibernate.entity.core;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseMasterEntity extends BaseEntity {

	private static final long serialVersionUID = 2583108868867866016L;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "APPROVAL_STATUS")
	private Integer approvalStatus;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	@Column(name = "VISIBILITY")
	private boolean visibility;

	public boolean getVisibility() {
		return this.visibility;
	}

	public Integer getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
