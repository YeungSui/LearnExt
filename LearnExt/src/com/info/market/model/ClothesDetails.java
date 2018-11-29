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
 * ClothesDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLOTHES_DETAILS", schema = "GGUSER")
public class ClothesDetails implements java.io.Serializable {

	// Fields

	private BigDecimal goodsId;
	private GoodsDetails goodsDetails;
	private String goodsName;
	private String goodsDescription;
	private Double goodsPrice;
	private String clothesSize;
	private String clothesColor;
	private String clothesMaterial;

	// Constructors

	/** default constructor */
	public ClothesDetails() {
	}

	/** minimal constructor */
	public ClothesDetails(BigDecimal goodsId, GoodsDetails goodsDetails,
			String goodsName, Double goodsPrice, String clothesSize,
			String clothesColor, String clothesMaterial) {
		this.goodsId = goodsId;
		this.goodsDetails = goodsDetails;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.clothesSize = clothesSize;
		this.clothesColor = clothesColor;
		this.clothesMaterial = clothesMaterial;
	}

	/** full constructor */
	public ClothesDetails(BigDecimal goodsId, GoodsDetails goodsDetails,
			String goodsName, String goodsDescription, Double goodsPrice,
			String clothesSize, String clothesColor, String clothesMaterial) {
		this.goodsId = goodsId;
		this.goodsDetails = goodsDetails;
		this.goodsName = goodsName;
		this.goodsDescription = goodsDescription;
		this.goodsPrice = goodsPrice;
		this.clothesSize = clothesSize;
		this.clothesColor = clothesColor;
		this.clothesMaterial = clothesMaterial;
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

	@Column(name = "CLOTHES_SIZE", nullable = false, length = 256)
	public String getClothesSize() {
		return this.clothesSize;
	}

	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}

	@Column(name = "CLOTHES_COLOR", nullable = false, length = 256)
	public String getClothesColor() {
		return this.clothesColor;
	}

	public void setClothesColor(String clothesColor) {
		this.clothesColor = clothesColor;
	}

	@Column(name = "CLOTHES_MATERIAL", nullable = false, length = 256)
	public String getClothesMaterial() {
		return this.clothesMaterial;
	}

	public void setClothesMaterial(String clothesMaterial) {
		this.clothesMaterial = clothesMaterial;
	}

}