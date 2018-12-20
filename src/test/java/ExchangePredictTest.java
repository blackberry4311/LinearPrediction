import org.junit.Assert;
import org.junit.Test;
import test.ExchangePredict;

public class ExchangePredictTest {
	@Test
	public void testPredict() {
		Double result = ExchangePredict.predict("USD", "TRY", 12, 13);
		Assert.assertTrue("Predict fail", result == 3.263);
	}
}
