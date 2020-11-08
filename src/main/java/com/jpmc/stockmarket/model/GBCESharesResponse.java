package com.jpmc.stockmarket.model;

public class GBCESharesResponse {
	
	private Double gbce;
	
	@Override
	public String toString() {
		StringBuilder objectBuilder = new StringBuilder();
		objectBuilder.append("GBCESharesResponse [gbce=");
		objectBuilder.append(gbce);
		objectBuilder.append("]");
		return objectBuilder.toString();
	}

	private GBCESharesResponse(Builder builder) {
		this.gbce = builder.gbce;
	}

	public Double getGbce() {
		return gbce;
	}

	public void setGbce(Double gbce) {
		this.gbce = gbce;
	}

	public static class Builder {
		private Double gbce;

		public Builder() {
		}

		public Builder gbce(final Double gbce) {
			this.gbce = gbce;
			return this;
		}

		public GBCESharesResponse build() {
			return new GBCESharesResponse(this);
		}
	}

}
