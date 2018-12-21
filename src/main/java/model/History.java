package model;

import java.util.Map;

public class History {
	private String base;
	private Map<String, Double> rates;
	private Double timestamp;

	public History(String base, Map<String, Double> rates, Double timestamp) {
		this.base = base;
		this.rates = rates;
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Double getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Double timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
}
