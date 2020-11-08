package com.jpmc.stockmarket.request;

public class RetriveDividendYieldRequest {
	
	public String stockSymbol;
	
	public Integer stockPrice;

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public Integer getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Integer stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public String toString() {
		return "RetriveDividendYieldRequest [stockSymbol=" + stockSymbol + ", stockPrice=" + stockPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockPrice == null) ? 0 : stockPrice.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
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
		RetriveDividendYieldRequest other = (RetriveDividendYieldRequest) obj;
		if (stockPrice == null) {
			if (other.stockPrice != null)
				return false;
		} else if (!stockPrice.equals(other.stockPrice))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		return true;
	}


	
}
