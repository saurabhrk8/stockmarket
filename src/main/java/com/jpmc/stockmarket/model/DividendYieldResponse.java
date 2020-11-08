package com.jpmc.stockmarket.model;

import java.math.BigDecimal;

public class DividendYieldResponse {

	
	private BigDecimal dividendYield;

	private DividendYieldResponse(Builder builder) {
		
		this.dividendYield = builder.dividendYield;
	}


	public BigDecimal getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(BigDecimal dividendYield) {
		this.dividendYield = dividendYield;
	}

	
	public static class Builder {
	
		private BigDecimal dividendYield;

		public Builder() {
		}

		public Builder dividendYield(final BigDecimal dividendYield) {
			this.dividendYield = dividendYield;
			return this;
		}

		public DividendYieldResponse build() {
			return new DividendYieldResponse(this);
		}
	}

}
