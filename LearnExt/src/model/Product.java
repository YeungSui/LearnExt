package model;

import java.util.Date;

public class Product{
	private String name;
	private String description;
	private double price;
	private String producer;
	private Date producedDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Date getProducedDate() {
		return producedDate;
	}
	public void setProducedDate(Date producedDate) {
		this.producedDate = producedDate;
	}
}
