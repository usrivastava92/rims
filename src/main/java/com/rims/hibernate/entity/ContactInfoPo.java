package com.rims.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rims.hibernate.core.entities.BaseEntity;
import com.rims.hibernate.entity.masters.VendorPo;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfoPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "CONTACT_PERSON")
	private String contactPersonName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contactInfo")
	@Column(name = "PHONE_NUMBERS", nullable = false)
	private Set<PhoneNumberPo> phoneNumbers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contactInfofK")
	@Column(name = "ADDRESSES", nullable = false)
	private Set<AddressPo> addresses;

	@ManyToOne
	@JoinColumn(name = "VENDOR_fk", referencedColumnName = "id", nullable = false)
	private VendorPo vendorFk;

	public VendorPo getVendorFk() {
		return vendorFk;
	}

	public void setVendorFk(VendorPo vendorFk) {
		this.vendorFk = vendorFk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public Set<PhoneNumberPo> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumberPo> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<AddressPo> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressPo> addresses) {
		this.addresses = addresses;
	}

}
