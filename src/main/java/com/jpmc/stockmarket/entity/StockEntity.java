package com.jpmc.stockmarket.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockEntity implements Serializable {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	  private String stockSymbol;
	  public StockEntity() {
		super();
		
	}

	private String type;
	  private BigDecimal lastDivident;
	  private String fixedDivident;
	  private Integer parValue;
	  
	
	public StockEntity(String stockSymbol, String type, BigDecimal lastDivident, String fixedDivident,
			Integer parValue) {
		super();
		this.stockSymbol = stockSymbol;
		this.type = type;
		this.lastDivident = lastDivident;
		this.fixedDivident = fixedDivident;
		this.parValue = parValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fixedDivident == null) ? 0 : fixedDivident.hashCode());
		result = prime * result + ((lastDivident == null) ? 0 : lastDivident.hashCode());
		result = prime * result + ((parValue == null) ? 0 : parValue.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEntity other = (StockEntity) obj;
		if (fixedDivident == null) {
			if (other.fixedDivident != null)
				return false;
		} else if (!fixedDivident.equals(other.fixedDivident))
			return false;
		if (lastDivident == null) {
			if (other.lastDivident != null)
				return false;
		} else if (!lastDivident.equals(other.lastDivident))
			return false;
		if (parValue == null) {
			if (other.parValue != null)
				return false;
		} else if (!parValue.equals(other.parValue))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockEntity [stockSymbol=" + stockSymbol + ", type=" + type + ", lastDivident=" + lastDivident
				+ ", fixedDivident=" + fixedDivident + ", parValue=" + parValue + "]";
	}
	  

}
