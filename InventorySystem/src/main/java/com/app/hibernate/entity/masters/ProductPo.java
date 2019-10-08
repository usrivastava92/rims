package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.app.hibernate.core.entities.BaseMasterEntity;

@Entity
@Table(name = "PRODUCT")
public class ProductPo extends BaseMasterEntity {

	private static final long serialVersionUID = 1L;



	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCT_ATTRIBUTE", joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "id"))
	private Collection<GenericAttributePo> genericAttributes;

	public Collection<GenericAttributePo> getGenericAttributes(){
		return this.genericAttributes;

	}

	public void setGenericAttributes(Collection<GenericAttributePo> genericAttributes){
		this.genericAttributes=genericAttributes;
	}

	
}