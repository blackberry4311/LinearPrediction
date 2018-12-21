package test;

import model.Stored;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class Regression {
	public Double linearRegression(Map<Integer, Stored> data, Integer x) {
		double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
		int N = data.size();
		for (Map.Entry<Integer, Stored> entry : data.entrySet()) {
			sumX += entry.getValue().getX();
			sumY += entry.getValue().getY();
			sumX2 += entry.getValue().getxSquared();
			sumXY += entry.getValue().getxMultiplyY();
			sumY2 += entry.getValue().getySquared();
		}

		//slope value
		Double b = (N * sumXY - sumX * sumY) / (N * sumX2 - Math.pow(sumX, 2));
		//intercept value
		Double a = (sumY - b * sumX) / N;

		//caculate R squared
		Double r = (N * sumXY - sumX * sumY) / Math
				.sqrt((N * sumX2 - Math.pow(sumX, 2)) * (N * sumY2 - Math.pow(sumY, 2)));
		System.out.println("R squared is: " + Math.pow(r, 2));

		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return Double.valueOf(df.format(a + b * x));
		//		return a + b * x;
	}
}

