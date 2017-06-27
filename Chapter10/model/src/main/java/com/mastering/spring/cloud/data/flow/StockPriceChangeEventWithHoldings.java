package com.mastering.spring.cloud.data.flow;

public class StockPriceChangeEventWithHoldings extends StockPriceChangeEvent {

	private Integer holdings;

	public StockPriceChangeEventWithHoldings(StockPriceChangeEvent event, Integer holdings) {
		super(event.getStockTicker(), event.getOldPrice(), event.getNewPrice());
		this.holdings = holdings;
	}

	public Integer getHoldings() {
		return holdings;
	}

	@Override
	public String toString() {
		return String.format("StockPriceChangeEventWithHoldings [holdings=%s, toString()=%s]", holdings,
				super.toString());
	}

}
