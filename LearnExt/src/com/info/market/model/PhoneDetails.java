package com.info.market.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * PhoneDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PHONE_DETAILS", schema = "GGUSER")
public class PhoneDetails implements java.io.Serializable {

	// Fields

	private BigDecimal goodsId;
	private GoodsDetails goodsDetails;
	private String goodsName;
	private String goodsDescription;
	private Double goodsPrice;
	private Double phoneScreenSize;
	private String phoneCpu;
	private Double phoneBatteryCapacity;

	// Constructors

	/** default constructor */
	public PhoneDetails() {
	}

	/** minimal constructor */
	public PhoneDetails(BigDecimal goodsId, GoodsDetails goodsDetails,
			String goodsName, Double goodsPrice, Double phoneScreenSize,
			String phoneCpu, Double phoneBatteryCapacity) {
		this.goodsId = goodsId;
		this.goodsDetails = goodsDetails;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.phoneScreenSize = phoneScreenSize;
		this.phoneCpu = phoneCpu;
		this.phoneBatteryCapacity = phoneBatteryCapacity;
	}

	/** full constructor */
	public PhoneDetails(BigDecimal goodsId, GoodsDetails goodsDetails,
			String goodsName, String goodsDescription, Double goodsPrice,
			Double phoneScreenSize, String phoneCpu, Double phoneBatteryCapacity) {
		this.goodsId = goodsId;
		this.goodsDetails = goodsDetails;
		this.goodsName = goodsName;
		this.goodsDescription = goodsDescription;
		this.goodsPrice = goodsPrice;
		this.phoneScreenSize = phoneScreenSize;
		this.phoneCpu = phoneCpu;
		this.phoneBatteryCapacity = phoneBatteryCapacity;
	}

	// Property accessors
	@Id
	@Column(name = "GOODS_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(BigDecimal goodsId) {
		this.goodsId = goodsId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public GoodsDetails getGoodsDetails() {
		return this.goodsDetails;
	}

	public void setGoodsDetails(GoodsDetails goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	@Column(name = "GOODS_NAME", nullable = false, length = 256)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Lob
	@Column(name = "GOODS_DESCRIPTION")
	public String getGoodsDescription() {
		return this.goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	@Column(name = "GOODS_PRICE", nullable = false, precision = 126, scale = 0)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name = "PHONE_SCREEN_SIZE", nullable = false, precision = 126, scale = 0)
	public Double getPhoneScreenSize() {
		return this.phoneScreenSize;
	}

	public void setPhoneScreenSize(Double phoneScreenSize) {
		this.phoneScreenSize = phoneScreenSize;
	}

	@Column(name = "PHONE_CPU", nullable = false, length = 256)
	public String getPhoneCpu() {
		return this.phoneCpu;
	}

	public void setPhoneCpu(String phoneCpu) {
		this.phoneCpu = phoneCpu;
	}

	@Column(name = "PHONE_BATTERY_CAPACITY", nullable = false, precision = 126, scale = 0)
	public Double getPhoneBatteryCapacity() {
		return this.phoneBatteryCapacity;
	}

	public void setPhoneBatteryCapacity(Double phoneBatteryCapacity) {
		this.phoneBatteryCapacity = phoneBatteryCapacity;
	}

}