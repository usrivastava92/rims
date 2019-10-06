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
@Table(name = "ADDRESS")
public class AddressPo extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ_GEN")
	@SequenceGenerator(name = "ADDRESS_SEQ_GEN", sequenceName = "ADDRESS_SEQ", initialValue = 1)
	private Long id;

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2")
	private String addressline2;
	@Column(name = "AREA_NAME", nullable = false)
	private String areaNAME;
	@Column(name = "CITY_NAME", nullable = false)
	private String cityName;
	@Column(name = "STATE_NAME", nullable = false)
	private String stateName;
	@Column(name = "COUNTRY_NAME", nullable = false)
	private String countryName;
	@Column(name = "ZIP_CODE", nullable = false)
	private long zipCode;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@ManyToOne
	@JoinColumn(name = "CONTACT_INFO_fk", referencedColumnName = "id", nullable = false)
	private ContactInfoPo contactInfofK;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getAreaNAME() {
		return areaNAME;
	}

	public void setAreaNAME(String areaNAME) {
		this.areaNAME = areaNAME;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public ContactInfoPo getContactInfofK() {
		return contactInfofK;
	}

	public void setContactInfofK(ContactInfoPo contactInfofK) {
		this.contactInfofK = contactInfofK;
	}

}
