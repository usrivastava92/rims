package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.hibernate.entity.core.BaseMasterEntity;
import com.app.hibernate.entity.ProductClassificationPo;

@Entity
@Table(name = "PRODUCT")
public class ProductPo extends BaseMasterEntity {

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_ATTRIBUTE", joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "id"))
	private Collection<GenericAttributePo> genericAttributes;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "VENDOR_PRODUCT", joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "VENDOR_ID", referencedColumnName = "id"))
	private Collection<VendorPo> vendors;

	@OneToOne
	@JoinColumn(name = "PRODUCT_CLASSIFICATION_FK")
	private ProductClassificationPo productClassification;

	@Column(name = "BRAND")
	private String brand;

	public Collection<GenericAttributePo> getGenericAttributes() {
		return this.genericAttributes;

	}

	public Collection<VendorPo> getVendors() {
		return vendors;
	}

	public void setVendors(Collection<VendorPo> vendors) {
		this.vendors = vendors;
	}

	public void setGenericAttributes(Collection<GenericAttributePo> genericAttributes) {
		this.genericAttributes = genericAttributes;
	}

	public ProductClassificationPo getProductClassification() {
		return productClassification;
	}

	public void setProductClassification(ProductClassificationPo productClassification) {
		this.productClassification = productClassification;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}