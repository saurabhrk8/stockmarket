package com.jpmc.stockmarket.request;

public class PERatioRequest {
	
    public String symbol;
	
	public Integer stockPrice;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Integer stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockPrice == null) ? 0 : stockPrice.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		PERatioRequest other = (PERatioRequest) obj;
		if (stockPrice == null) {
			if (other.stockPrice != null)
				return false;
		} else if (!stockPrice.equals(other.stockPrice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PERatioRequest [symbol=" + symbol + ", stockPrice=" + stockPrice + "]";
	}

	
	

}
