package model;

import java.util.HashMap;
import java.util.Map;

public class History {
	private String base;
	private Map<String, Double> rates = new HashMap<>();
	private Double timestamp;

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
