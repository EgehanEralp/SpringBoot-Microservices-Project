package com.smartera.odev.Entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;





@Entity
@Table(name="Orders")
public class Order {

	@Id
	@Column(name="oid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
	
	@Column(name="cid")
	private int cid;
	
	
	
	//@Type(type="json")
	@Column(name = "products")
	private String products;


	public Order(int oid, int cid, String products) {
		this.oid = oid;
		this.cid = cid;
		this.products = products;
	}
	
	public Order() {
		
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}
	
	
	
	
}
