package com.rims.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rims.hibernate.core.entities.BaseEntity;

@Entity
@Table(name = "PURCHASE_DTL")
public class PurchaseDetailPo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;
	@Column(name = "DESIGN_NUMBER")
	private String designNumber;
	@Column(name = "HSN", nullable = false)
	private String hsn;
	@Column(name = "QUANTITY", nullable = false)
	private String quantity;
	@Column(name = "SIZE", nullable = false)
	private String size;
	@Column(name = "RATE", nullable = false)
	private BigDecimal rate;
	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;
	@Column(name = "DISCOUNT", nullable = false)
	private BigDecimal Discount;
	@Column(name = "TAXABLE_AMOUNT", nullable = false)
	private BigDecimal taxableAmount;
	@Column(name = "SGST_PERCENT")
	private String sgstPercent;
	@Column(name = "CGST_PERCENT")
	private BigDecimal cgstPercent;
	@Column(name = "IGST_PERCENT")
	private BigDecimal igstPercent;
	@Column(name = "SGST_AMOUNT")
	private BigDecimal sGstAmount;
	@Column(name = "CGST_AMOUNT", nullable = false)
	private BigDecimal cGstAmount;
	@Column(name = "IGST_AMOUNT", nullable = false)
	private BigDecimal iGstAmount;

	@Column(name = "GST_AMOUNT", nullable = false)
	private BigDecimal gstAmount;
	@Column(name = "NET_AMOUNT", nullable = false)
	private BigDecimal netAmount;
	@ManyToOne
	@JoinColumn(name = "PURCHASE_HDR_FK", referencedColumnName = "id", nullable = false)
	private PurchaseHeaderPo purchaseHdrFk;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesignNumber() {
		return designNumber;
	}

	public void setDesignNumber(String designNumber) {
		this.designNumber = designNumber;
	}

	public String getHsn() {
		return hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getDiscount() {
		return Discount;
	}

	public void setDiscount(BigDecimal discount) {
		Discount = discount;
	}

	public BigDecimal getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(BigDecimal taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public String getSgstPercent() {
		return sgstPercent;
	}

	public void setSgstPercent(String sgstPercent) {
		this.sgstPercent = sgstPercent;
	}

	public BigDecimal getCgstPercent() {
		return cgstPercent;
	}

	public void setCgstPercent(BigDecimal cgstPercent) {
		this.cgstPercent = cgstPercent;
	}

	public BigDecimal getIgstPercent() {
		return igstPercent;
	}

	public void setIgstPercent(BigDecimal igstPercent) {
		this.igstPercent = igstPercent;
	}

	public BigDecimal getsGstAmount() {
		return sGstAmount;
	}

	public void setsGstAmount(BigDecimal sGstAmount) {
		this.sGstAmount = sGstAmount;
	}

	public BigDecimal getcGstAmount() {
		return cGstAmount;
	}

	public void setcGstAmount(BigDecimal cGstAmount) {
		this.cGstAmount = cGstAmount;
	}

	public BigDecimal getiGstAmount() {
		return iGstAmount;
	}

	public void setiGstAmount(BigDecimal iGstAmount) {
		this.iGstAmount = iGstAmount;
	}

	public BigDecimal getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(BigDecimal gstAmount) {
		this.gstAmount = gstAmount;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public PurchaseHeaderPo getPurchaseHdrFk() {
		return purchaseHdrFk;
	}

	public void setPurchaseHdrFk(PurchaseHeaderPo purchaseHdrFk) {
		this.purchaseHdrFk = purchaseHdrFk;
	}

}
