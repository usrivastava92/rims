package com.app.hibernate.entity.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseMasterEntity;

@Entity
@Table(name = "GENERIC_ATTRIBUTE")
public class GenericAttributePo extends BaseMasterEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "DTYPE")
	private String dtype;

	@Column(name = "PARENT_ATTRIBUTE")
	private String parentAttribute;

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getParentAttribute() {
		return this.parentAttribute;
	}

	public void setParentAttribute(String parentAttribute) {
		this.parentAttribute = parentAttribute;
	}

}
