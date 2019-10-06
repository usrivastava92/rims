package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumberPo extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_NUMBER_SEQ_GEN")
	@SequenceGenerator(name = "PHONE_NUMBER_SEQ_GEN", sequenceName = "PHONE_NUMBER_SEQ", initialValue = 1)
	private Long id;

	@Column(name = "PHONE_TYPE")
	private String phoneType;
	@Column(name = "PHONE_NUMBER", nullable = false, unique = true)
	private Long phoneNumber;
	@Column(name = "PHONE_EXTENSION")
	private int phoneExtension;

	public Long getId() {
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

}
