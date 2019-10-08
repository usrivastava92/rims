package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCT_ATTRIBUTE", joinColumns = @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"))
	private Collection<ProductPo> products;

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


	public Collection<ProductPo> getProducts(){
		return this.products;
	}

	public void setProducts(Collection<ProductPo> products){
		this.products=products;
	}


}
