package com.app.hibernate.entity.masters;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseMasterEntity;

@Entity
@Table(name = "PRODUCT")
public class ProductPo extends BaseMasterEntity {

	private static final long serialVersionUID = 1L;

}