package com.jpmc.stockmarket.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import com.jpmc.stockmarket.model.TradeType;


@Entity
@DynamicUpdate
public class TradeEntity implements Serializable {
	
	@Id
	private  String symbol;
	private  TradeType type;
	private  Double tradedPrice;
	private  Long sharesQuantity;
	private  Date timestamp;



	public TradeEntity() {
		super();
		
	}

	public TradeEntity(String symbol, TradeType type, Double tradedPrice, Long sharesQuantity, Date timestamp) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.tradedPrice = tradedPrice;
		this.sharesQuantity = sharesQuantity;
		this.timestamp = timestamp;
	}



	public TradeType getType() {
		return type;
	}

	public Double getTradedPrice() {
		return tradedPrice;
	}

	public Long getSharesQuantity() {
		return sharesQuantity;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	 public static Builder builder() {
	        return new Builder();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sharesQuantity == null) ? 0 : sharesQuantity.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((tradedPrice == null) ? 0 : tradedPrice.hashCode());
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
		TradeEntity other = (TradeEntity) obj;
		if (sharesQuantity == null) {
			if (other.sharesQuantity != null)
				return false;
		} else if (!sharesQuantity.equals(other.sharesQuantity))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (tradedPrice == null) {
			if (other.tradedPrice != null)
				return false;
		} else if (!tradedPrice.equals(other.tradedPrice))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Trade [symbol=");
		builder2.append(symbol);
		builder2.append(", type=");
		builder2.append(type);
		builder2.append(", tradedPrice=");
		builder2.append(tradedPrice);
		builder2.append(", sharesQuantity=");
		builder2.append(sharesQuantity);
		builder2.append(", timestamp=");
		builder2.append(timestamp);
		builder2.append("]");
		return builder2.toString();
	}

	public static class Builder {
		private String symbol;
		private TradeType type;
		private Double tradedPrice;
		private Long sharesQuantity;
		private Date timestamp;

		public Builder symbol(final String symbol) {
			this.symbol = symbol;
			return this;
		}

		public Builder type(final TradeType type) {
			this.type = type;
			return this;
		}

		public Builder tradedPrice(final Double tradedPrice) {
			this.tradedPrice = tradedPrice;
			return this;
		}

		public Builder sharesQuantity(final Long sharesQuantity) {
			this.sharesQuantity = sharesQuantity;
			return this;
		}

		public Builder timestamp(final Date timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public TradeEntity build() {
			return new TradeEntity(symbol, type, tradedPrice, sharesQuantity, timestamp);
		}
	}
}
