package com.rims.hibernate.entity;

import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "PURCHASE_HDR")
public class PurchaseHeaderPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "INVOICE_NUMBER", nullable = false, unique = true)
	private long invoiceNumber;

	@Column(name = "PURCHASE_DATE", nullable = false)
	private Date purchaseDate;

	@Column(name = "PURCHASE_DUE_DATE")
	private Date purcahseDueDate;

	@Column(name = "AMOUNT_BEFORE_TAX", nullable = false)
	private BigDecimal amountBeforeTax;

	@Column(name = "PACKING_CHARGES")
	private BigDecimal packingCharges;

	@Column(name = "SGST_AMOUNT")
	private BigDecimal sgstAmount;

	@Column(name = "CGST_AMOUNT")
	private BigDecimal cgstAmount;

	@Column(name = "IGST_AMOUNT")
	private BigDecimal igstAmount;

	@Column(name = "DUE_AMOUNT")
	private BigDecimal dueAmount;

	@Column(name = "TOTAL_AMOUNT", nullable = false)
	private BigDecimal totalAmount;

	@Column(name = "TRANSPORTER_NAME", nullable = false)
	private String transporterName;

	@Column(name = "TRANSPORT_GST_NUMBER")
	private String transporterGstNumber;

	@Column(name = "WAYBILL_NUMBER")
	private String wayBillNumber;

	@Column(name = "TRANSPORT_COST", nullable = false)
	private BigDecimal transportCost;

	@ManyToOne(optional = false)
	@JoinColumn(name = "VENDOR_FK", referencedColumnName = "id", nullable = false)
	private VendorPo vendor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseHdrFk")
	@Column(name = "PURCHASE_DTL", nullable = false)
	private Set<PurchaseDetailPo> purchaseDetails;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseHDRfK")
	@Column(name = "PAYMENT_DETAILS", nullable = false)
	private Set<PaymentDetailsPo> paymentDetails;

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getPurcahseDueDate() {
		return purcahseDueDate;
	}

	public void setPurcahseDueDate(Date purcahseDueDate) {
		this.purcahseDueDate = purcahseDueDate;
	}

	public BigDecimal getAmountBeforeTax() {
		return amountBeforeTax;
	}

	public void setAmountBeforeTax(BigDecimal amountBeforeTax) {
		this.amountBeforeTax = amountBeforeTax;
	}

	public BigDecimal getPackingCharges() {
		return packingCharges;
	}

	public void setPackingCharges(BigDecimal packingCharges) {
		this.packingCharges = packingCharges;
	}

	public BigDecimal getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(BigDecimal sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public BigDecimal getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(BigDecimal cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public BigDecimal getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(BigDecimal igstAmount) {
		this.igstAmount = igstAmount;
	}

	public BigDecimal getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterGstNumber() {
		return transporterGstNumber;
	}

	public void setTransporterGstNumber(String transporterGstNumber) {
		this.transporterGstNumber = transporterGstNumber;
	}

	public String getWayBillNumber() {
		return wayBillNumber;
	}

	public void setWayBillNumber(String wayBillNumber) {
		this.wayBillNumber = wayBillNumber;
	}

	public BigDecimal getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(BigDecimal transportCost) {
		this.transportCost = transportCost;
	}

	/*
	 * public VendorPo getVendor() { return vendor; }
	 * 
	 * public void setVendor(VendorPo vendor) { this.vendor = vendor; }
	 */

	public Set<PurchaseDetailPo> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(Set<PurchaseDetailPo> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public Set<PaymentDetailsPo> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(Set<PaymentDetailsPo> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

}
