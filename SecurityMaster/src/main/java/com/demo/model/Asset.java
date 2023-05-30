package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.demo.enums.AssetClass;

@Entity
public class Asset {
	
	@Id
	private String assetId;
	//@Enumerated(EnumType.STRING)
	private String assetClasses;
	private String subAssetClass;
	private String risk;
	private String investmentHorizon;
	private String liquidity;
	private String returns;
	
	
	
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
//	public AssetsEnums getAssetClasses() {
//		return assetClasses;
//	}
//	public void setAssetClasses(AssetsEnums assetClasses) {
//		this.assetClasses = assetClasses;
//	}
	
	public String getLiquidity() {
		return liquidity;
	}
	public String getAssetClasses() {
		return assetClasses;
	}
	public void setAssetClasses(String assetClasses) {
		this.assetClasses = assetClasses;
	}
	public void setLiquidity(String liquidity) {
		this.liquidity = liquidity;
	}
	public String getReturns() {
		return returns;
	}
	public void setReturns(String returns) {
		this.returns = returns;
	}
	public String getSubAssetClass() {
		return subAssetClass;
	}
	public void setSubAssetClass(String subAssetClass) {
		this.subAssetClass = subAssetClass;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getInvestmentHorizon() {
		return investmentHorizon;
	}
	public void setInvestmentHorizon(String investmentHorizon) {
		this.investmentHorizon = investmentHorizon;
	}
	

}
