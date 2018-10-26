package com.info.market.model;

import java.math.BigDecimal;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;

/**
 * ClothesDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clothes_details", schema = "GGUSER")
@DiscriminatorValue("CLOTHES")
public class ClothesDetails extends GoodsDetails implements Serializable {

	// Fields

	private String clsize;
	private String clcolor;
	private String clmaterial;

	// Constructors

	/** default constructor */
	public ClothesDetails() {
	}

	/** minimal constructor */
	public ClothesDetails(String clsize, String clcolor,
			String clmaterial) {
		this.clsize = clsize;
		this.clcolor = clcolor;
		this.clmaterial = clmaterial;
	}

	// Property accessors

	@Column(name = "clothes_size", nullable = false, length = 5)
	public String getClsize() {
		return this.clsize;
	}

	public void setClsize(String clsize) {
		this.clsize = clsize;
	}

	@Column(name = "clothes_color", nullable = false, length = 256)
	public String getClcolor() {
		return this.clcolor;
	}

	public void setClcolor(String clcolor) {
		this.clcolor = clcolor;
	}

	@Column(name = "clothes_material", nullable = false, length = 256)
	public String getClmaterial() {
		return this.clmaterial;
	}

	public void setClmaterial(String clmaterial) {
		this.clmaterial = clmaterial;
	}

}