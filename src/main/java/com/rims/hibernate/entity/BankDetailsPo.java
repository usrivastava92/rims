package com.rims.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rims.hibernate.core.entities.BaseEntity;
import com.rims.hibernate.entity.masters.VendorPo;

@Entity
@Table(name = "BANK_DETAILS")
public class BankDetailsPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "ACCOUNT_NUMBER", nullable = false)
	private String accountNumber;

	@Column(name = "IFSC_CODE", nullable = false)
	private String ifscCode;
	@Column(name = "ACCOUNT_HOLDER_NAME", nullable = false)
	private String accountHolderName;
	@Column(name = "BANK_NAME", nullable = false)
	private String bankName;
	@Column(name = "BANK_BRANCH", nullable = false)
	private String bankBranch;
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@OneToOne
	@JoinColumn(name = "VENDOR_FK", referencedColumnName = "id")
	private VendorPo vendor;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public VendorPo getVendor() {
		return vendor;
	}

	public void setVendor(VendorPo vendor) {
		this.vendor = vendor;
	}

}
