package test;

import model.History;
import model.Stored;

import java.util.HashMap;
import java.util.Map;

public class ExchangePredict {
	private Regression regression;
	private OpenExchangeApiClient apiClient;

	public ExchangePredict() {
		regression = new Regression();
		apiClient = new OpenExchangeApiClient();
	}

	public Double predict(String from, String to, int defaultStep, int predictStep) {
		Map<Integer, Stored> storedData = new HashMap<>();
		try {
			int count = 0;
			for (int i = 0; i < defaultStep; i++) {
				String year = String.valueOf(6 + i / 12);
				count++;
				String month = count < 10 ? "0" + count : "" + count;
				if (count / 12 == 1) count = 0;

				History history = apiClient.getHistory(String.format("201%s-%s-15", year, month), from, to);
				Double toValue = history.getRates().get(to);
				storedData.put(i + 1, new Stored(i + 1, toValue));
			}
		} catch (Throwable th) {
			System.out.println(th.getMessage());
		}
		return regression.linearRegression(storedData, predictStep);
	}

	public static void main(String... args) {
		String from = "USD";
		String to = "TRY";
		int defaultStep = 12;
		int predictStep = 13;
		if (args.length > 0) {
			try {
				from = args[0];
				to = args[1];
				defaultStep = Integer.valueOf(args[2]);
				predictStep = Integer.valueOf(args[3]);
			} catch (IndexOutOfBoundsException iox) {
				//do nothing
			}
		}
		System.out.println(
				String.format("predict with value from %s to %s, defaultStep %s, predictStep %s", from, to, defaultStep,
						predictStep));
		ExchangePredict predict = new ExchangePredict();
		Double result = predict.predict(from, to, defaultStep, predictStep);
		System.out.println("Predict result for step " + predictStep + ": " + result);
	}
}
