package com.info.market.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * UserDetails entity. @author MyEclipse Persistence Tools
 */
@Cacheable(true)
@Entity
@Table(name = "user_details", schema = "GGUSER")
public class UserDetails implements java.io.Serializable {

	// Fields

	private BigDecimal uid;
	private String uname;
	private String udescription;
	@JsonIgnore
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	// Constructors

	/** default constructor */
	public UserDetails() {
	}

	/** minimal constructor */
	public UserDetails(BigDecimal uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}

	/** full constructor */
	public UserDetails(BigDecimal uid, String uname, String udescription,
			Set<OrderDetails> orderDetailses) {
		this.uid = uid;
		this.uname = uname;
		this.udescription = udescription;
		this.orderDetailses = orderDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, precision = 38, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userGen")
	@SequenceGenerator(name="userGen", sequenceName="SEQ_USERDETAILS", allocationSize=1)	
	public BigDecimal getUid() {
		return this.uid;
	}

	public void setUid(BigDecimal uid) {
		this.uid = uid;
	}

	@Column(name = "user_name", nullable = false, length = 256)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Lob
	@Column(name = "user_description")
	public String getUdescription() {
		return this.udescription;
	}

	public void setUdescription(String udescription) {
		this.udescription = udescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userDetails")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}