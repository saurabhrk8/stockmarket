package com.jpmc.stockmarket.model;

import java.math.BigDecimal;



public class StockResponse {
	
	  private String type;
	  private BigDecimal lastDivident;
	  private String fixedDivident;
	  private Integer parValue;
	  
	  
	  private StockResponse(Builder builder) {
			
			this.type = builder.type;
			this.lastDivident=builder.lastDivident;
			this.fixedDivident=builder.fixedDivident;
			this.parValue=builder.parValue;
		}
	  
	  
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getLastDivident() {
		return lastDivident;
	}
	public void setLastDivident(BigDecimal lastDivident) {
		this.lastDivident = lastDivident;
	}
	public String getFixedDivident() {
		return fixedDivident;
	}
	public void setFixedDivident(String fixedDivident) {
		this.fixedDivident = fixedDivident;
	}
	public Integer getParValue() {
		return parValue;
	}
	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}
	  
	 
	
	public static class Builder {
		
		 private String type;
		  private BigDecimal lastDivident;
		  private String fixedDivident;
		  private Integer parValue;

		public Builder() {
		}

		public Builder type(final String type) {
			this.type = type;
			return this;
		}
		
		public Builder lastDivident(final BigDecimal lastDivident) {
			this.lastDivident = lastDivident;
			return this;
		}
		
		public Builder parValue(final Integer parValue) {
			this.parValue = parValue;
			return this;
		}
		
		public Builder fixedDivident(final String fixedDivident) {
			this.fixedDivident = fixedDivident;
			return this;
		}
		

		public StockResponse build() {
			return new StockResponse(this);
		}
	}

}
