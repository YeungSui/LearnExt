package com.info.market.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_details", schema = "GGUSER")
public class OrderDetails implements java.io.Serializable {

	// Fields

	private BigDecimal orid;
	private GoodsDetails goodsDetails;
	private UserDetails userDetails;
	private Timestamp ortime;
	private String ornotes;

	// Constructors

	/** default constructor */
	public OrderDetails() {
	}

	/** minimal constructor */
	public OrderDetails(BigDecimal orid, Timestamp ortime) {
		this.orid = orid;
		this.ortime = ortime;
	}

	/** full constructor */
	public OrderDetails(BigDecimal orid, GoodsDetails goodsDetails,
			UserDetails userDetails, Timestamp ortime, String ornotes) {
		this.orid = orid;
		this.goodsDetails = goodsDetails;
		this.userDetails = userDetails;
		this.ortime = ortime;
		this.ornotes = ornotes;
	}

	// Property accessors
	@Id
	@Column(name = "order_id", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getOrid() {
		return this.orid;
	}

	public void setOrid(BigDecimal orid) {
		this.orid = orid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gid")
	public GoodsDetails getGoodsDetails() {
		return this.goodsDetails;
	}

	public void setGoodsDetails(GoodsDetails goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid")
	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Column(name = "order_time", nullable = false, length = 11)
	public Timestamp getOrtime() {
		return this.ortime;
	}

	public void setOrtime(Timestamp ortime) {
		this.ortime = ortime;
	}

	@Lob
	@Column(name = "order_notes")
	public String getOrnotes() {
		return this.ornotes;
	}

	public void setOrnotes(String ornotes) {
		this.ornotes = ornotes;
	}

}