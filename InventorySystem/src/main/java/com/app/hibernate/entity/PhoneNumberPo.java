package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseEntity;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumberPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "PHONE_TYPE")
	private String phoneType;
	@Column(name = "PHONE_NUMBER", nullable = false, unique = true)
	private Long phoneNumber;
	@Column(name = "PHONE_EXTENSION")
	private int phoneExtension;

	@ManyToOne
	@JoinColumn(name = "CONTACT_INFO_fk", referencedColumnName = "id", nullable = false)
	private ContactInfoPo contactInfo;

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneExtension() {
		return phoneExtension;
	}

	public void setPhoneExtension(int phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	public ContactInfoPo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfoPo contactInfo) {
		this.contactInfo = contactInfo;
	}

}
