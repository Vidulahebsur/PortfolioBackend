package com.demo.dto;

public class ThemeAssetResponseDto {
		private int id;
		private String themeName;
		private String assetClass;
		private String subAssetClass;
		private String risk;
		private double allocation;
		private String investmentHorizon;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getThemeName() {
			return themeName;
		}
		public void setThemeName(String themeName) {
			this.themeName = themeName;
		}
		public String getAssetClass() {
			return assetClass;
		}
		public void setAssetClass(String assetClass) {
			this.assetClass = assetClass;
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
		public double getAllocation() {
			return allocation;
		}
		public void setAllocation(double allocation) {
			this.allocation = allocation;
		}
		public String getInvestmentHorizon() {
			return investmentHorizon;
		}
		public void setInvestmentHorizon(String investmentHorizon) {
			this.investmentHorizon = investmentHorizon;
		}
		
		
	}


