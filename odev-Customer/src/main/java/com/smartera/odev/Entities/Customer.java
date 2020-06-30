package com.smartera.odev.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	
	@Id
	@Column(name="cid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="orderpermission")
	private boolean orderpermission;
	

	public Customer(int cid, String name, String password, boolean orderpermission) {
		this.cid = cid;
		this.name = name;
		this.password = password;
		this.orderpermission = orderpermission;
	}
	
	public Customer() {}
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isOrderpermission() {
		return orderpermission;
	}

	public void setOrderpermission(boolean orderpermission) {
		this.orderpermission = orderpermission;
	}
	
	
	
	
}
