package com.rims.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rims.hibernate.core.entities.BaseEntity;

@Entity
@Table(name = "PAYEMENT_DETAILS")
public class PaymentDetailsPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "PAYMENT_DATE", nullable = false)
	private Date paymentDate;
	@Column(name = "PAYMENT_TYPE", nullable = false)
	private String paymentType;
	@Column(name = "PAYMENT_AMOUNT", nullable = false)
	private String paymentAmount;
	@Column(name = "TRANSACTION_REF_NO")
	private String transactionRefNumber;

	@ManyToOne
	@JoinColumn(name = "PURCHASE_HDR_FK", referencedColumnName = "id", nullable = false)
	private PurchaseHeaderPo purchaseHDRfK;

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
