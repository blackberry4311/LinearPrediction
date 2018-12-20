package test;

import model.Stored;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class Regression {
	public static Double linearRegression(Map<Integer, Stored> data, Integer x) {
		double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
		int N = data.size();
		for (Map.Entry<Integer, Stored> entry : data.entrySet()) {
			sumX += entry.getValue().getX();
			sumY += entry.getValue().getY();
			sumX2 += entry.getValue().getxSquare();
			sumXY += entry.getValue().getxMultiplyY();
		}

		//slope value
		Double b = (N * sumXY - sumX * sumY) / (N * sumX2 - Math.pow(sumX, 2));
		//intercept value
		Double a = (sumY - b * sumX) / N;

		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return Double.valueOf(df.format(a + b * x));
		//		return a + b * x;
	}
}

