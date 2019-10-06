package com.app.hibernate.entity;

import java.util.Date;

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
@Table(name="PAYEMENT_DETAILS")
public class PaymentDetailsPo extends BaseEntity{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYEMENT_DETAILS_GEN")
	@SequenceGenerator(name = "PAYEMENT_DETAILS_GEN", sequenceName = "PAYEMENT_DETAILS_SEQ", initialValue = 1)
	@Column(name="id")
private Long  ID;	
	@Column(name="PAYMENT_DATE",nullable=false)
private Date paymentDate;

@Column(name="PAYMENT_TYPE", nullable=false)
private String paymentType;
@Column(name="PAYMENT_AMOUNT",nullable=false)
private String paymentAmount;
@Column(name="TRANSACTION_REF_NO")
private String transactionRefNumber;
	
@ManyToOne
@JoinColumn(name="PURCHASE_HDR_FK",referencedColumnName = "id", nullable=false)
private PurchaseHeaderPo purchaseHDRfK;

public Long getID() {
	return ID;
}

public void setID(Long iD) {
	ID = iD;
}

public Date getPaymentDate() {
	return paymentDate;
}

public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}

public String getPaymentType() {
	return paymentType;
}

public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}

public String getPaymentAmount() {
	return paymentAmount;
}

public void setPaymentAmount(String paymentAmount) {
	this.paymentAmount = paymentAmount;
}

public String getTransactionRefNumber() {
	return transactionRefNumber;
}

public void setTransactionRefNumber(String transactionRefNumber) {
	this.transactionRefNumber = transactionRefNumber;
}

public PurchaseHeaderPo getPurchaseHDRfK() {
	return purchaseHDRfK;
}

public void setPurchaseHDRfK(PurchaseHeaderPo purchaseHDRfK) {
	this.purchaseHDRfK = purchaseHDRfK;
}


	
}
