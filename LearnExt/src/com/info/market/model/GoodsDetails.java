package com.info.market.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * GoodsDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_details", schema = "GGUSER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class GoodsDetails implements java.io.Serializable {

	// Fields

	private BigDecimal gid;
	private String gname;
	private String gdescription;
	private Double gprice;
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);
	private Set<PhoneDetails> phoneDetailses = new HashSet<PhoneDetails>(0);
	private Set<ClothesDetails> clothesDetailses = new HashSet<ClothesDetails>(
			0);

	// Constructors

	/** default constructor */
	public GoodsDetails() {
	}

	/** minimal constructor */
	public GoodsDetails(BigDecimal gid, String gname, Double gprice) {
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
	}

	/** full constructor */
	public GoodsDetails(BigDecimal gid, String gname, String gdescription,
			Double gprice, Set<OrderDetails> orderDetailses,
			Set<PhoneDetails> phoneDetailses,
			Set<ClothesDetails> clothesDetailses) {
		this.gid = gid;
		this.gname = gname;
		this.gdescription = gdescription;
		this.gprice = gprice;
		this.orderDetailses = orderDetailses;
		this.phoneDetailses = phoneDetailses;
		this.clothesDetailses = clothesDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "goods_id", unique = true, nullable = false, precision = 38, scale = 0)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public BigDecimal getGid() {
		return this.gid;
	}

	public void setGid(BigDecimal gid) {
		this.gid = gid;
	}

	@Column(name = "goods_name", nullable = false, length = 256)
	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@Lob
	@Column(name = "goods_description")
	public String getGdescription() {
		return this.gdescription;
	}

	public void setGdescription(String gdescription) {
		this.gdescription = gdescription;
	}

	@Column(name = "goods_price", nullable = false, precision = 126, scale = 0)
	public Double getGprice() {
		return this.gprice;
	}

	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goodsDetails")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}
}