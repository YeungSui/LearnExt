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
@Table(name = "ORDER_DETAILS", schema = "GGUSER")
public class OrderDetails implements java.io.Serializable {

	// Fields

	private BigDecimal orderId;
	private UserDetails userDetails;
	private GoodsDetails goodsDetails;
	private Timestamp orderTime;
	private String orderNotes;

	// Constructors

	/** default constructor */
	public OrderDetails() {
	}

	/** minimal constructor */
	public OrderDetails(BigDecimal orderId, Timestamp orderTime) {
		this.orderId = orderId;
		this.orderTime = orderTime;
	}

	/** full constructor */
	public OrderDetails(BigDecimal orderId, UserDetails userDetails,
			GoodsDetails goodsDetails, Timestamp orderTime, String orderNotes) {
		this.orderId = orderId;
		this.userDetails = userDetails;
		this.goodsDetails = goodsDetails;
		this.orderTime = orderTime;
		this.orderNotes = orderNotes;
	}

	// Property accessors
	@Id
	@Column(name = "ORDER_ID", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getOrderId() {
		return this.orderId;
	}

	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOODS_ID")
	public GoodsDetails getGoodsDetails() {
		return this.goodsDetails;
	}

	public void setGoodsDetails(GoodsDetails goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	@Column(name = "ORDER_TIME", nullable = false, length = 11)
	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	@Lob
	@Column(name = "ORDER_NOTES")
	public String getOrderNotes() {
		return this.orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

}