package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ThemeAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@ManyToOne
	private Theme theme;
	@ManyToOne
	private Asset asset;
	private double allocation;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public double getAllocation() {
		return allocation;
	}
	public void setAllocation(double allocation) {
		this.allocation = allocation;
	}
	
}
