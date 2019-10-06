package com.app.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VENDOR")
public class VendorPo extends BaseEntity

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDOR_SEQ_GEN")
	@SequenceGenerator(name = "VENDOR_SEQ_GEN", sequenceName = "VENDOR_SEQ", initialValue = 1)
	@Column(name = "id")
	private Long id;

	public BankDetailsPo getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetailsPo bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Column(name = "VENDOR_NAME", nullable = false)
	private String vendorName;

	@Column(name = "GST_NUMBER", nullable = false, unique = true)
	private String gstNumber;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendorFk")
	@Column(name = "CONTACT_INFO", nullable = false)
	private Set<ContactInfoPo> contacts;

	@OneToOne
	@JoinColumn(name = "BANK_DETAILS", referencedColumnName = "id")
	private BankDetailsPo bankDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public Set<ContactInfoPo> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactInfoPo> contacts) {
		this.contacts = contacts;
	}

}
