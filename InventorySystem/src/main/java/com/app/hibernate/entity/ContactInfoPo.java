package com.app.hibernate.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfoPo  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_INFO_SEQ_GEN")
	@SequenceGenerator(name = "CONTACT_INFO_SEQ_GEN", sequenceName = "CONTACT_INFO_SEQ", initialValue = 1)
	
	@Column(name="id")
	private Long id;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "EMAIL" , unique=true)
	 String email;
	/*
	 * @Column(name="LASTNAME") String MiddleName;
	 */
	// String LastName;
	@Column(name = "CONTACT_PERSON")
	String contactPersonName;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactInfo")
	 @Column ( name ="PHONE_NUMBERS", nullable = false )
	 private Set<PhoneNumberPo> phoneNumbers;
	 
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy ="contactInfofK")
	 @Column ( name ="ADDRESSES", nullable = false )
	   private Set<AddressPo> addresses;
	 
		@ManyToOne
		@JoinColumn(name="VENDOR_fk",referencedColumnName = "id", nullable=false)
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
