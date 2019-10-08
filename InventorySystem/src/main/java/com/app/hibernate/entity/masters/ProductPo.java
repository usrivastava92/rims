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



	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_ATTRIBUTE", joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "id"))
	private Collection<GenericAttributePo> genericAttributes;

	public Collection<GenericAttributePo> getGenericAttributes(){
		return this.genericAttributes;

	}
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "VENDOR_PRODUCT", joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "VENDOR_ID", referencedColumnName = "id"))
	private Collection<VendorPo> vendors;
	
	
	
	
	
	
	

	public Collection<VendorPo> getVendors() {
		return vendors;
	}








	public void setVendors(Collection<VendorPo> vendors) {
		this.vendors = vendors;
	}








	public void setGenericAttributes(Collection<GenericAttributePo> genericAttributes){
		this.genericAttributes=genericAttributes;
	}

	
}