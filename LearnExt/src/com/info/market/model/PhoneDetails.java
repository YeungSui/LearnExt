package com.info.market.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PhoneDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "phone_details", schema = "GGUSER")
@DiscriminatorValue("PHONE")
public class PhoneDetails extends GoodsDetails implements java.io.Serializable {

	// Fields

	private Double phscreenSize;
	private String phcpu;
	private Double phbatteryCapacity;

	// Constructors

	/** default constructor */
	public PhoneDetails() {
	}

	/** minimal constructor */
	public PhoneDetails(Double phscreenSize, String phcpu,
			Double phbatteryCapacity) {
		this.phscreenSize = phscreenSize;
		this.phcpu = phcpu;
		this.phbatteryCapacity = phbatteryCapacity;
	}

	@Column(name = "phone_screen_size", nullable = false, precision = 126, scale = 0)
	public Double getPhscreenSize() {
		return this.phscreenSize;
	}

	public void setPhscreenSize(Double phscreenSize) {
		this.phscreenSize = phscreenSize;
	}

	@Column(name = "phone_cpu", nullable = false, length = 256)
	public String getPhcpu() {
		return this.phcpu;
	}

	public void setPhcpu(String phcpu) {
		this.phcpu = phcpu;
	}

	@Column(name = "phone_battery_capacity", nullable = false, precision = 126, scale = 0)
	public Double getPhbatteryCapacity() {
		return this.phbatteryCapacity;
	}

	public void setPhbatteryCapacity(Double phbatteryCapacity) {
		this.phbatteryCapacity = phbatteryCapacity;
	}

}