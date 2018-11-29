package com.info.market.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * GoodsDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GOODS_DETAILS", schema = "GGUSER")
public class GoodsDetails implements java.io.Serializable {

	// Fields

	private BigDecimal goodsId;
	private String goodsName;
	private String goodsDescription;
	private Double goodsPrice;
	private PhoneDetails phoneDetails;
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);
	private ClothesDetails clothesDetails;

	// Constructors

	/** default constructor */
	public GoodsDetails() {
	}

	/** minimal constructor */
	public GoodsDetails(BigDecimal goodsId, String goodsName, Double goodsPrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}

	/** full constructor */
	public GoodsDetails(BigDecimal goodsId, String goodsName,
			String goodsDescription, Double goodsPrice,
			PhoneDetails phoneDetails, Set<OrderDetails> orderDetailses,
			ClothesDetails clothesDetails) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDescription = goodsDescription;
		this.goodsPrice = goodsPrice;
		this.phoneDetails = phoneDetails;
		this.orderDetailses = orderDetailses;
		this.clothesDetails = clothesDetails;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "goodsDetails")
	public PhoneDetails getPhoneDetails() {
		return this.phoneDetails;
	}

	public void setPhoneDetails(PhoneDetails phoneDetails) {
		this.phoneDetails = phoneDetails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goodsDetails")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "goodsDetails")
	public ClothesDetails getClothesDetails() {
		return this.clothesDetails;
	}

	public void setClothesDetails(ClothesDetails clothesDetails) {
		this.clothesDetails = clothesDetails;
	}

}